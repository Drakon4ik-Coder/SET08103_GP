package com.napier.sem;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    //static Main app;

    @BeforeAll
    static void init() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            addDummyData(session);
        }
        HibernateUtil.shutdown();
    }

    private static void addDummyData(Session session) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Create dummy countries
            Country country1 = new Country();
            country1.setCode("CNT1");
            country1.setName("Country 1");
            country1.setContinent(Continent.Asia);
            country1.setRegion("Region 1");
            country1.setPopulation(10000000);

            Country country2 = new Country();
            country2.setCode("CNT2");
            country2.setName("Country 2");
            country2.setContinent(Continent.Europe);
            country2.setRegion("Region 2");
            country2.setPopulation(15000000);

            // Create dummy cities
            City city1 = new City();
            city1.setName("City 1");
            city1.setCountry(country1);
            city1.setDistrict("District 1");
            city1.setPopulation(1000000);

            City city2 = new City();
            city2.setName("City 2");
            city2.setCountry(country2);
            city2.setDistrict("District 2");
            city2.setPopulation(1500000);

            // Set capitals for countries
            country1.setCapital(city1);
            country2.setCapital(city2);

            // Save entities
            session.save(country1);
            session.save(country2);
            session.save(city1);
            session.save(city2);


            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Test
    void testCountryWorldNegativeLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getWorldDesc(), -1);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCountryWorldNoLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getWorldDesc(), 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCountryWorldLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getWorldDesc(), 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 2", c.get(0).getName());
    }

    @Test
    void testCountryContinentNegativeLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getContinentDesc("Asia"), -1);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryContinentNoLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getContinentDesc("Asia"), 0);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryContinentLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getContinentDesc("Asia"), 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 1", c.get(0).getName());
    }

    @Test
    void testCountryRegionNegativeLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getRegionDesc("Region 1"), -1);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryRegionNoLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getRegionDesc("Region 1"), 0);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryRegionLimit() {
        List<Country> c = DBReader.queryCountries(Query.Country.getRegionDesc("Region 1"), 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 1", c.get(0).getName());
    }

    @Test
    void testCityWorldNegativeLimit() {
        List<City> c = DBReader.queryCities(Query.Country.getWorldDesc(), -1);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCityWorldNoLimit() {
        List<City> c = DBReader.queryCities(Query.Country.getWorldDesc(), 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCityWorldLimit() {
        List<City> c = DBReader.queryCities(Query.City.getWorldDesc(), 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 2", c.get(0).getName());
    }

    @Test
    void testCapitalCityWorldLimit() {
        //String expected = "FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC";
        List<City> c = DBReader.queryCities(Query.CapitalCity.getWorldDesc(), 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testQueryCapitalCityContinentDesc() {
        Continent continent = Continent.Europe; // Initialize a Continent enum
        String expected = "FROM City c WHERE c.id = c.country.capital.id AND c.country.continent = 'Europe' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.getContinentDesc(continent));
    }

    @Test
    void testQueryCapitalCityRegionDesc() {
        String region = "Western Europe"; // Initialize a region string
        String expected = "FROM City c WHERE c.id = c.country.capital.id AND c.country.region = 'Western Europe' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.getRegionDesc(region));
    }

    @Test
    void testQueryCityWorldDesc() {
        String expected = "FROM City c ORDER BY population DESC";
        Assertions.assertEquals(expected,Query.City.getWorldDesc());
    }

    @Test
    void testQueryCityContinentDesc() {
        String continent = "Asia"; // Initialize a continent string
        String expected = "FROM City c WHERE c.country.continent = 'Asia' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.getContinentDesc(continent));
    }

    @Test
    void testQueryCityCountryDesc() {
        String country = "China"; // Initialize a country string
        String expected = "FROM City c WHERE c.country.name = 'China' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.getCountryDesc(country));
    }

    @Test
    void testQueryCityRegionDesc() {
        String region = "East Asia"; // Initialize a region string
        String expected = "FROM City c WHERE c.country.region = 'East Asia' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.getRegionDesc(region));
    }

    @Test
    void testQueryCityDistrictDesc() {
        String district = "Pudong"; // Initialize a district string
        String expected = "FROM City c WHERE c.district = 'Pudong' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.getDistrictDesc(district));
    }

    @Test
    void testQueryCountryWorldDesc() {
        String expected = "From Country c ORDER BY population DESC";
        Assertions.assertEquals(expected, Query.Country.getWorldDesc());
    }

    @Test
    void testQueryCountryContinentDesc() {
        String continent = "Africa"; // Initialize a continent string
        String expected = "FROM Country c WHERE c.continent = 'Africa' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.Country.getContinentDesc(continent));
    }

    @Test
    void testQueryCountryRegionDesc() {
        String region = "Northern Africa"; // Initialize a region string
        String expected = "FROM Country c WHERE c.region = 'Northern Africa' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.Country.getRegionDesc(region));
    }
}

