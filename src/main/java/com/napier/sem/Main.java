package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = DBReader.queryCountries("FROM Country", 10);
        for (Country country : countries) {
            System.out.println(country.toString());
        }

        List<City> cities = DBReader.queryCities("FROM City", 10);
        for (City city : cities) {
            System.out.println(city.toString());
        }
        System.out.println("1");
    }
}

