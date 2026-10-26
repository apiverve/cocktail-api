/// Response models for the Cocktail Recipe API.

/// API Response wrapper.
class CocktailResponse {
  final String status;
  final dynamic error;
  final CocktailData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  CocktailResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory CocktailResponse.fromJson(Map<String, dynamic> json) => CocktailResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? CocktailData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Cocktail Recipe API.

class CocktailData {
  num? count;
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
  num? ingredientCount;
  String? estimatedStrength;
  String? preparation;

  CocktailDataCocktailsItem({
    this.name,
    this.glass,
    this.category,
    this.ingredients,
    this.ingredientCount,
    this.estimatedStrength,
    this.preparation,
  });

  factory CocktailDataCocktailsItem.fromJson(Map<String, dynamic> json) => CocktailDataCocktailsItem(
      name: json['name'],
      glass: json['glass'],
      category: json['category'],
      ingredients: (json['ingredients'] as List?)?.map((e) => CocktailDataCocktailsItemIngredientsItem.fromJson(e)).toList(),
      ingredientCount: json['ingredientCount'],
      estimatedStrength: json['estimatedStrength'],
      preparation: json['preparation'],
    );
}

class CocktailDataCocktailsItemIngredientsItem {
  String? unit;
  num? amount;
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
  String name;

  CocktailRequest({
    required this.name,
  });

  Map<String, dynamic> toJson() => {
      'name': name,
    };
}
