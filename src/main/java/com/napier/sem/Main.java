package com.napier.sem;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
//--Capital City
        System.out.println("World capital city population descending:");
        List<City> capCities = DBReader.queryCities(Query.CapitalCity.getWorldDesc(), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
        System.out.println("\nAsian continent capital city population descending:");
        capCities = DBReader.queryCities(Query.CapitalCity.getContinentDesc(Continent.Asia), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
        System.out.println("\nCaribbean region capital city population descending:");
        capCities = DBReader.queryCities(Query.CapitalCity.getRegionDesc("Caribbean"), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
//--City
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
//--
    }
}

