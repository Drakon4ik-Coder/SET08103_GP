package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
        System.out.println("\nCarribean region capital city population descending:");
        capCities = DBReader.queryCities(Query.CapitalCity.getRegionDesc("Caribbean"), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
    }
}

