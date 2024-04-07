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
        List<Country> c = DBReader.queryDB(Query.Country.WORLD_DESC, -1);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCountryWorldNoLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.WORLD_DESC, 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCountryWorldLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.WORLD_DESC, 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 2", c.get(0).getName());
    }

    @Test
    void testCountryContinentNegativeLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.CONTINENT_DESC,  -1, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryContinentNoLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.CONTINENT_DESC,  0, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryContinentLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.CONTINENT_DESC,  1, "Asia");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 1", c.get(0).getName());
    }

    @Test
    void testCountryRegionNegativeLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.REGION_DESC,  -1, "Region 1");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryRegionNoLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.REGION_DESC,  0, "Region 1");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCountryRegionLimit() {
        List<Country> c = DBReader.queryDB(Query.Country.REGION_DESC,  1, "Region 1");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("Country 1", c.get(0).getName());
    }

    @Test
    void testCityWorldNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.City.WORLD_DESC, -1);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCityWorldNoLimit() {
        List<City> c = DBReader.queryDB(Query.City.WORLD_DESC, 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCityWorldLimit() {
        List<City> c = DBReader.queryDB(Query.City.WORLD_DESC, 1);
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 2", c.get(0).getName());
    }

    @Test
    void testCityContinentNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.City.CONTINENT_DESC, -1, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityContinentLimit() {
        List<City> c = DBReader.queryDB(Query.City.CONTINENT_DESC, 1, "Asia");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 1", c.get(0).getName());
    }

    @Test
    void testCityContinentNoLimit() {
        List<City> c = DBReader.queryDB(Query.City.CONTINENT_DESC, 0, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityRegionLimit() {
        List<City> c = DBReader.queryDB(Query.City.REGION_DESC, 1, "Region 2");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 2", c.get(0).getName());
    }

    @Test
    void testCityRegionNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.City.REGION_DESC, -1, "Region 2");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityRegionNoLimit() {
        List<City> c = DBReader.queryDB(Query.City.REGION_DESC, 0, "Region 2");
        Assertions.assertEquals(1, c.size());
    }


    @Test
    void testCityCountryNoLimit() {
        List<City> c = DBReader.queryDB(Query.City.COUNTRY_DESC, 0, "Country 2");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityCountryLimit() {
        List<City> c = DBReader.queryDB(Query.City.COUNTRY_DESC, 1, "Country 2");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 2", c.get(0).getName());
    }

    @Test
    void testCityCountryNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.City.COUNTRY_DESC, -1, "Country 2");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityDistrictNoLimit() {
        List<City> c = DBReader.queryDB(Query.City.DISTRICT_DESC, 0, "District 1");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCityDistrictLimit() {
        List<City> c = DBReader.queryDB(Query.City.DISTRICT_DESC, 1, "District 1");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 1", c.get(0).getName());
    }

    @Test
    void testCityDistrictNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.City.DISTRICT_DESC, -1, "District 1");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCapitalCityWorldNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.WORLD_DESC,-1);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testCapitalCityWorldLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.WORLD_DESC,1);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCapitalCityContinentLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, 1, "Asia");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 1", c.get(0).getName());
    }

    @Test
    void testCapitalCityContinentNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, -1, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCapitalCityContinentNoLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, 0, "Asia");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCapitalCityRegionLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.REGION_DESC, 1, "Region 2");
        Assertions.assertEquals(1, c.size());
        Assertions.assertEquals("City 2", c.get(0).getName());
    }

    @Test
    void testCapitalCityRegionNegativeLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.REGION_DESC, -1, "Region 2");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testCapitalCityRegionNoLimit() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.REGION_DESC, 2, "Region 2");
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testDBReaderQuery() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, 0);
        Assertions.assertEquals(2, c.size());
    }

    @Test
    void testPopulationWorld() {
        List<Population> c = DBReader.queryDB(Query.Population.WORLD, 0);
        Assertions.assertEquals(1, c.size());
    }

    @Test
    void testPopulationContinent() {
        List<Population> c = DBReader.queryDB(Query.Population.CONTINENT, 0, "Asia");
        Assertions.assertEquals(1, c.size());
    }
}

