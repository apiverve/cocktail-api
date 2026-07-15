declare module '@apiverve/cocktail' {
  export interface cocktailOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface cocktailResponse {
    status: string;
    error: string | null;
    data: CocktailRecipeData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface CocktailRecipeData {
      count:      number | null;
      filteredOn: null | string;
      cocktails:  Cocktail[];
  }
  
  interface Cocktail {
      name:               null | string;
      glass:              null | string;
      category:           null | string;
      ingredients:        Ingredient[];
      ingredientCount?:   number | null;
      estimatedStrength?: null | string;
      preparation:        null | string;
      garnish?:           null | string;
  }
  
  interface Ingredient {
      unit?:       Unit | null;
      amount?:     number | null;
      ingredient?: null | string;
      label?:      null | string;
      special?:    null | string;
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
