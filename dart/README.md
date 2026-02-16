# Cocktail Recipe API - Dart/Flutter Client

Cocktail is a simple tool for getting cocktail recipes. It returns the ingredients, instructions, and more of the cocktail.

[![pub package](https://img.shields.io/pub/v/apiverve_cocktail.svg)](https://pub.dev/packages/apiverve_cocktail)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Cocktail Recipe API](https://apiverve.com/marketplace/cocktail?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_cocktail: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_cocktail/apiverve_cocktail.dart';

void main() async {
  final client = CocktailClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'name': 'martini'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 5,
    "filteredOn": "name",
    "cocktails": [
      {
        "name": "Espresso Martini",
        "glass": "martini",
        "category": "After Dinner Cocktail",
        "ingredients": [
          {
            "unit": "cl",
            "amount": 5,
            "ingredient": "Vodka"
          },
          {
            "unit": "cl",
            "amount": 1,
            "ingredient": "Coffee liqueur",
            "label": "Kahlúa"
          },
          {
            "special": "Sugar syrup (according to individual preference of sweetness)"
          },
          {
            "special": "1 short strong Espresso"
          }
        ],
        "preparation": "Shake and strain into a chilled cocktail glass."
      },
      {
        "name": "Lemon Drop Martini",
        "glass": "martini",
        "category": "All Day Cocktail",
        "ingredients": [
          {
            "unit": "cl",
            "amount": 2.5,
            "ingredient": "Vodka",
            "label": "Citron Vodka"
          },
          {
            "unit": "cl",
            "amount": 2,
            "ingredient": "Triple Sec"
          },
          {
            "unit": "cl",
            "amount": 1.5,
            "ingredient": "Lemon juice"
          }
        ],
        "garnish": "Lemon slice",
        "preparation": "Shake and strain into a chilled cocktail glass rimmed with sugar."
      },
      {
        "name": "French Martini",
        "glass": "martini",
        "category": "Before Dinner Cocktail",
        "ingredients": [
          {
            "unit": "cl",
            "amount": 4.5,
            "ingredient": "Vodka"
          },
          {
            "unit": "cl",
            "amount": 1.5,
            "ingredient": "Raspberry liqueur"
          },
          {
            "unit": "cl",
            "amount": 1.5,
            "ingredient": "Pineapple juice"
          }
        ],
        "preparation": "Stir in mixing glass with ice cubes. Strain into chilled cocktail glass. Squeeze oil from lemon peel onto the drink."
      },
      {
        "name": "Dirty Martini",
        "glass": "martini",
        "category": "Before Dinner Cocktail",
        "ingredients": [
          {
            "unit": "cl",
            "amount": 6,
            "ingredient": "Vodka"
          },
          {
            "unit": "cl",
            "amount": 1,
            "ingredient": "Vermouth",
            "label": "Dry vermouth"
          },
          {
            "unit": "cl",
            "amount": 1,
            "ingredient": "Olive juice"
          }
        ],
        "garnish": "Green olive",
        "preparation": "Stir in mixing glass with ice cubes. Strain into chilled martini glass."
      },
      {
        "name": "Dry Martini",
        "glass": "martini",
        "category": "Before Dinner Cocktail",
        "ingredients": [
          {
            "unit": "cl",
            "amount": 6,
            "ingredient": "Gin"
          },
          {
            "unit": "cl",
            "amount": 1,
            "ingredient": "Vermouth",
            "label": "Dry vermouth"
          }
        ],
        "preparation": "Stir in mixing glass with ice cubes. Strain into chilled martini glass. Squeeze oil from lemon peel onto the drink, or garnish with olive."
      }
    ]
  }
}
```

## API Reference

- **API Home:** [Cocktail Recipe API](https://apiverve.com/marketplace/cocktail?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/cocktail](https://docs.apiverve.com/ref/cocktail?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
