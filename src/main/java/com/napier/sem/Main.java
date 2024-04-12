package com.napier.sem;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
//--Capital City
        System.out.println("World capital city population descending:");
        List<City> capCities = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, 10);
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
        System.out.println("\nAsian continent capital city population descending:");
        capCities = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, 10, Continent.Asia.name());
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
        System.out.println("\nCaribbean region capital city population descending:");
        capCities = DBReader.queryDB(Query.CapitalCity.REGION_DESC,10, "Caribbean");
        for (City capCity : capCities) {
            System.out.println(capCity.toStringCapital());
        }
//--City
        List<City> citiesWorld = DBReader.queryDB(Query.City.WORLD_DESC, 10);
        for (City city : citiesWorld) {
            System.out.println(city.toString());
        }

        List<City> citiesContinent = DBReader.queryDB(Query.City.CONTINENT_DESC, 10, Continent.Asia.name());
        for (City city : citiesContinent) {
            System.out.println(city.toString());
        }

        List<City> citiesCountry = DBReader.queryDB(Query.City.COUNTRY_DESC, 10, "France");
        for (City city : citiesCountry) {
            System.out.println(city.toString());
        }

        List<City> citiesRegion = DBReader.queryDB(Query.City.REGION_DESC, 10, "Polynesia");
        for (City city : citiesRegion) {
            System.out.println(city.toString());
        }

        List<City> citiesDistrict = DBReader.queryDB(Query.City.DISTRICT_DESC, 10, "Rajasthan");
        for (City city : citiesDistrict) {
            System.out.println(city.toString());
        }
//--Country
        System.out.println("\nWorld country population descending:");
        List<Country> Countries = DBReader.queryDB(Query.Country.WORLD_DESC, 10);
        for (Country c : Countries) {
            System.out.println(c.toString());
        }
        System.out.println("\nAsian continent country population descending:");
        Countries = DBReader.queryDB(Query.Country.CONTINENT_DESC, 10, Continent.Asia.name());
        for (Country c : Countries) {
            System.out.println(c.toString());
        }
        System.out.println("\nWestern Europe region country population descending:");
        Countries = DBReader.queryDB(Query.Country.REGION_DESC, 10, "Western Europe");
        for (Country c : Countries) {
            System.out.println(c.toString());
        }
//--Language
        System.out.println("\nLanguage report with the number of speakers and percentage of world population (in descending order):");
        List<Object[]> languageSpeakers = DBReader.queryDBNonEntity(Query.Language.LANGUAGE_DESC, 0, "");
        for (Object[] row : languageSpeakers) {
            String language = (String) row[0];
            if (language.equals("Chinese") || language.equals("English") || language.equals("Hindi") || language.equals("Spanish") || language.equals("Arabic")) {
                Double totalSpeakers = (Double) row[1];
                Double percentageOfWorldPopulation = (Double) row[2];
                System.out.printf("%s: %d speakers (%.2f%% of world population)\n", language, totalSpeakers.intValue(), percentageOfWorldPopulation);
            }
        }
    }
}

