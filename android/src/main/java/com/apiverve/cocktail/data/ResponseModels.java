// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     CocktailRecipeData data = Converter.fromJsonString(jsonString);

package com.apiverve.cocktail.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static CocktailRecipeData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CocktailRecipeData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(CocktailRecipeData.class);
        writer = mapper.writerFor(CocktailRecipeData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// CocktailRecipeData.java

package com.apiverve.cocktail.data;

import com.fasterxml.jackson.annotation.*;

public class CocktailRecipeData {
    private long count;
    private String filteredOn;
    private Cocktail[] cocktails;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("filteredOn")
    public String getFilteredOn() { return filteredOn; }
    @JsonProperty("filteredOn")
    public void setFilteredOn(String value) { this.filteredOn = value; }

    @JsonProperty("cocktails")
    public Cocktail[] getCocktails() { return cocktails; }
    @JsonProperty("cocktails")
    public void setCocktails(Cocktail[] value) { this.cocktails = value; }
}

// Cocktail.java

package com.apiverve.cocktail.data;

import com.fasterxml.jackson.annotation.*;

public class Cocktail {
    private String name;
    private String glass;
    private String category;
    private Ingredient[] ingredients;
    private String preparation;
    private String garnish;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("glass")
    public String getGlass() { return glass; }
    @JsonProperty("glass")
    public void setGlass(String value) { this.glass = value; }

    @JsonProperty("category")
    public String getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(String value) { this.category = value; }

    @JsonProperty("ingredients")
    public Ingredient[] getIngredients() { return ingredients; }
    @JsonProperty("ingredients")
    public void setIngredients(Ingredient[] value) { this.ingredients = value; }

    @JsonProperty("preparation")
    public String getPreparation() { return preparation; }
    @JsonProperty("preparation")
    public void setPreparation(String value) { this.preparation = value; }

    @JsonProperty("garnish")
    public String getGarnish() { return garnish; }
    @JsonProperty("garnish")
    public void setGarnish(String value) { this.garnish = value; }
}

// Ingredient.java

package com.apiverve.cocktail.data;

import com.fasterxml.jackson.annotation.*;

public class Ingredient {
    private Unit unit;
    private Double amount;
    private String ingredient;
    private String label;
    private String special;

    @JsonProperty("unit")
    public Unit getUnit() { return unit; }
    @JsonProperty("unit")
    public void setUnit(Unit value) { this.unit = value; }

    @JsonProperty("amount")
    public Double getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(Double value) { this.amount = value; }

    @JsonProperty("ingredient")
    public String getIngredient() { return ingredient; }
    @JsonProperty("ingredient")
    public void setIngredient(String value) { this.ingredient = value; }

    @JsonProperty("label")
    public String getLabel() { return label; }
    @JsonProperty("label")
    public void setLabel(String value) { this.label = value; }

    @JsonProperty("special")
    public String getSpecial() { return special; }
    @JsonProperty("special")
    public void setSpecial(String value) { this.special = value; }
}

// Unit.java

package com.apiverve.cocktail.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Unit {
    CL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case CL: return "cl";
        }
        return null;
    }

    @JsonCreator
    public static Unit forValue(String value) throws IOException {
        if (value.equals("cl")) return CL;
        throw new IOException("Cannot deserialize Unit");
    }
}