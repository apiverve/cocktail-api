using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.CocktailRecipe
{
    /// <summary>
    /// Query options for the Cocktail Recipe API
    /// </summary>
    public class CocktailRecipeQueryOptions
    {
        /// <summary>
        /// The name of the cocktail for which you want to get the recipe (e.g., martini)
        /// Example: martini
        /// </summary>
        [JsonProperty("name")]
        public string Name { get; set; }
    }
}
