declare module '@apiverve/cocktail' {
  export interface cocktailOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface cocktailResponse {
    status: string;
    error: string | null;
    data: CocktailRecipeData;
    code?: number;
  }


  interface CocktailRecipeData {
      count:      number;
      filteredOn: string;
      cocktails:  Cocktail[];
  }
  
  interface Cocktail {
      name:        string;
      glass:       string;
      category:    string;
      ingredients: Ingredient[];
      preparation: string;
      garnish?:    string;
  }
  
  interface Ingredient {
      unit?:       Unit;
      amount?:     number;
      ingredient?: string;
      label?:      string;
      special?:    string;
  }
  
  enum Unit {
      Cl = "cl",
  }

  export default class cocktailWrapper {
    constructor(options: cocktailOptions);

    execute(callback: (error: any, data: cocktailResponse | null) => void): Promise<cocktailResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: cocktailResponse | null) => void): Promise<cocktailResponse>;
    execute(query?: Record<string, any>): Promise<cocktailResponse>;
  }
}
