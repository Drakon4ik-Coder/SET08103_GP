package com.napier.sem;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*List<Country> countries = DBReader.queryCountries("FROM Country", 10);
        for (Country country : countries) {
            System.out.println(country.toString());
        }

        List<City> cities = DBReader.queryCities("FROM City", 10);
        for (City city : cities) {
            System.out.println(city.toString());
        }*/

        // Country Report for region(limit N)
        List<Country> topNPopulatedCountries = getTopPopulatedCountries(10);
        for (Country country : topNPopulatedCountries) {
            try {
                System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
            }
            catch (NullPointerException e) {
                continue;
            }
        }
        // Country Report for world
        List<Country> topPopulatedCountries = getTopPopulatedCountries(0);
        for (Country country : topPopulatedCountries) {
            try {
                System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
            }
            catch (NullPointerException e) {
                continue;
            }
        }
    }

    public static List<Country> getTopPopulatedCountries(int limit) {
        String hqlQuery = "FROM Country ORDER BY population DESC";
        return DBReader.queryCountries(hqlQuery, limit);
    }
}

