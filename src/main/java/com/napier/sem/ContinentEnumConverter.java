package com.napier.sem;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
 * Continent class converter
 * Transform enum values to string
 */
@Converter(autoApply = true)
public class ContinentEnumConverter implements AttributeConverter<Continent, String> {

    @Override
    public String convertToDatabaseColumn(Continent continent) {
        if (continent == null) {
            return null;
        }
        switch (continent) {
            case Asia:
                return "Asia";
            case Europe:
                return "Europe";
            case NorthAmerica:
                return "North America";
            case Africa:
                return "Africa";
            case Oceania:
                return "Oceania";
            case Antarctica:
                return "Antarctica";
            case SouthAmerica:
                return "South America";
            default:
                throw new IllegalArgumentException("Unknown continent: " + continent);
        }
    }

    @Override
    public Continent convertToEntityAttribute(String continent) {
        if (continent == null) {
            return null;
        }
        switch (continent) {
            case "Asia":
                return Continent.Asia;
            case "Europe":
                return Continent.Europe;
            case "North America":
                return Continent.NorthAmerica;
            case "Africa":
                return Continent.Africa;
            case "Oceania":
                return Continent.Oceania;
            case "Antarctica":
                return Continent.Antarctica;
            case "South America":
                return Continent.SouthAmerica;
            default:
                throw new IllegalArgumentException("Unknown continent: " + continent);
        }
    }
}
