package com.napier.sem;

public enum Continent {
    Asia,
    Europe,
    NorthAmerica,
    Africa,
    Oceania,
    Antarctica,
    SouthAmerica;

    public static Continent fromString(String continent) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        String cleanContinent = continent.replaceAll("\\s", "").toLowerCase();

        for (Continent c : Continent.values()) {
            // Remove spaces from enum constant name and convert to lowercase for comparison
            String enumName = c.name().replaceAll("\\s", "").toLowerCase();
            if (enumName.equalsIgnoreCase(cleanContinent)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid continent name: " + continent);
    }
}