/// Response models for the Cocktail Recipe API.

/// API Response wrapper.
class CocktailResponse {
  final String status;
  final dynamic error;
  final CocktailData? data;

  CocktailResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory CocktailResponse.fromJson(Map<String, dynamic> json) => CocktailResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CocktailData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the Cocktail Recipe API.

class CocktailData {
  int? count;
  String? filteredOn;
  List<CocktailDataCocktailsItem>? cocktails;

  CocktailData({
    this.count,
    this.filteredOn,
    this.cocktails,
  });

  factory CocktailData.fromJson(Map<String, dynamic> json) => CocktailData(
      count: json['count'],
      filteredOn: json['filteredOn'],
      cocktails: (json['cocktails'] as List?)?.map((e) => CocktailDataCocktailsItem.fromJson(e)).toList(),
    );
}

class CocktailDataCocktailsItem {
  String? name;
  String? glass;
  String? category;
  List<CocktailDataCocktailsItemIngredientsItem>? ingredients;
  String? preparation;

  CocktailDataCocktailsItem({
    this.name,
    this.glass,
    this.category,
    this.ingredients,
    this.preparation,
  });

  factory CocktailDataCocktailsItem.fromJson(Map<String, dynamic> json) => CocktailDataCocktailsItem(
      name: json['name'],
      glass: json['glass'],
      category: json['category'],
      ingredients: (json['ingredients'] as List?)?.map((e) => CocktailDataCocktailsItemIngredientsItem.fromJson(e)).toList(),
      preparation: json['preparation'],
    );
}

class CocktailDataCocktailsItemIngredientsItem {
  String? unit;
  int? amount;
  String? ingredient;

  CocktailDataCocktailsItemIngredientsItem({
    this.unit,
    this.amount,
    this.ingredient,
  });

  factory CocktailDataCocktailsItemIngredientsItem.fromJson(Map<String, dynamic> json) => CocktailDataCocktailsItemIngredientsItem(
      unit: json['unit'],
      amount: json['amount'],
      ingredient: json['ingredient'],
    );
}

class CocktailRequest {
  String? name;

  CocktailRequest({
    this.name,
  });

  Map<String, dynamic> toJson() => {
      if (name != null) 'name': name,
    };
}
