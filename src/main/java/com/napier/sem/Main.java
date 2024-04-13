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

        List<Population> Populations = DBReader.queryDB(Query.Population.WORLD, 0);
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
        Populations = DBReader.queryDB(Query.Population.CONTINENT, 0, "Asia");
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
        Populations = DBReader.queryDB(Query.Population.COUNTRY, 0, "Ukraine");
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
        Populations = DBReader.queryDB(Query.Population.REGION, 0, "Western Europe");
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
        Populations = DBReader.queryDB(Query.Population.DISTRICT, 0, "Kiova");
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
        Populations = DBReader.queryDB(Query.Population.CITY, 0, "Kyiv");
        for (Population p: Populations) {
            System.out.println(p.toString());
        }
    }
}

