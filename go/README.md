# Cocktail Recipe API - Go Client

Cocktail is a simple tool for getting cocktail recipes. It returns the ingredients, instructions, and more of the cocktail.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Cocktail Recipe API](https://apiverve.com/marketplace/cocktail?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/cocktail-api/go
```

---

## Configuration

Before using the Cocktail Recipe API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Cocktail Recipe API documentation is found here: [https://docs.apiverve.com/ref/cocktail](https://docs.apiverve.com/ref/cocktail?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/cocktail-api/go"
)

func main() {
    // Create a new client
    client := cocktail.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "name": "martini"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

## Example Response

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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
