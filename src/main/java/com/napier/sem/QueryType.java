package com.napier.sem;

public enum QueryType {
    CITY(City.class),
    COUNTRY(Country.class),
    CAPITAL_CITY(City.class),
    POPULATION(Population.class);
    public final Class queryClass;
    private <T> QueryType(Class<T> classQuery) {
        this.queryClass=classQuery;
    }
}