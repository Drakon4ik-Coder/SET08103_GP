package com.napier.sem;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {

        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);

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
    }
}

