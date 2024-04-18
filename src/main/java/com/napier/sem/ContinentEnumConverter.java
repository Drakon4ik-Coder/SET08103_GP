package com.napier.sem;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * This class converts Continent enum values to and from database strings.
 */
@Converter(autoApply = true)
public class ContinentEnumConverter implements AttributeConverter<Continent, String> {

    /**
     * Converts a Continent enum value to a database string.
     *
     * @param continent the Continent enum value to convert.
     * @return the database string representation of the Continent.
     * @throws IllegalArgumentException if the Continent is not recognized.
     */
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

    /**
     * Converts a database string to a Continent enum value.
     *
     * @param continent the database string to convert.
     * @return the Continent enum value represented by the database string.
     * @throws IllegalArgumentException if the database string is not recognized.
     */
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
