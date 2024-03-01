package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Country> countries = DBReader.queryCountries("FROM Country");
        for (Country country : countries) {
            System.out.println(country.toString());
        }


    }
}

