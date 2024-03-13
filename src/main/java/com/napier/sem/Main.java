package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> capCities = DBReader.queryCities(Query.CapitalCity.getWorldDesc(), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }

        List<City> citiesWorld = DBReader.queryCities(Query.City.getWorldDesc(), 10);
        for (City city : citiesWorld) {
            System.out.println(city.toString());
        }

        List<City> citiesContinent = DBReader.queryCities(Query.City.getContinentDesc("Asia"), 10);
        for (City city : citiesContinent) {
            System.out.println(city.toString());
        }

        List<City> citiesCountry = DBReader.queryCities(Query.City.getCountryDesc("France"), 10);
        for (City city : citiesCountry) {
            System.out.println(city.toString());
        }

        System.out.println("2");
    }
}

