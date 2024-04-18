package com.napier.sem;

/**
 * Enumeration class to define the types of queries that can be made
 */
public enum QueryType {
    /**
     * Query type for city-related data
     */
    CITY(City.class),

    /**
     * Query type for country-related data
     */
    COUNTRY(Country.class),

    /**
     * Query type for capital city-related data
     */
    CAPITAL_CITY(City.class),

    /**
     * Query type for language-related data
     */
    LANGUAGE(CountryLanguage.class),

    /**
     * Query type for population-related data
     */
    POPULATION(Population.class);

    /**
     * The class associated with the query type
     */
    public final Class queryClass;

    /**
     * Constructor for the QueryType enumeration
     *
     * @param classQuery The class associated with the query type
     */
    private <T> QueryType(Class<T> classQuery) {
        this.queryClass = classQuery;
    }
}
