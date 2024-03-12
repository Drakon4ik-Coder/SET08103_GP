package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = DBReader.queryCountries("FROM Country c ORDER BY c.population DESC", 10);
        for (Country country : countries) {
            System.out.println(country.toString());
        }

        List<City> cities = DBReader.queryCities("FROM City c ORDER BY c.population DESC", 10);
        for (City city : cities) {
            System.out.println(city.toString());
        }

        List<City> capCities = DBReader.queryCities("FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC", 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }

        System.out.println("2");
    }
}

