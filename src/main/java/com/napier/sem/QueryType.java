package com.napier.sem;

/*
 * QueryType enumerator
 * stores all queries types
 */
public enum QueryType {
    CITY(City.class),
    COUNTRY(Country.class),
    CAPITAL_CITY(City.class),
    LANGUAGE(CountryLanguage.class),
    POPULATION(Population.class);
  
    public final Class queryClass;
    private <T> QueryType(Class<T> classQuery) {
        this.queryClass=classQuery;
    }
}
