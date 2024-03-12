package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<City> capCities = DBReader.queryCities(Query.CapitalCity.getWorldDesc(), 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }

        System.out.println("2");
    }
}

