package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {
    static Main app;
    @BeforeAll
    static void init() {
        app = new Main();
    }

    @Test
    void country_report_for_world_test_negative_limit() {
        DBReader.queryDB(Query.Country.WORLD_DESC, -1);
    }
    @Test
    void city_report_for_world_test_negative_limit() {
        DBReader.queryDB(Query.Country.WORLD_DESC, -1);
    }

    @Test
    void testQueryCapitalCityWorldDesc() {
        String expected = "FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.WORLD_DESC.getQuery());
    }

    @Test
    void testQueryCapitalCityContinentDesc() {
        Continent continent = Continent.Europe; // Initialize a Continent enum
        String expected = "FROM City c WHERE c.id = c.country.capital.id AND c.country.continent = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.CONTINENT_DESC.getQuery());
    }

    @Test
    void testQueryCapitalCityRegionDesc() {
        String region = "Western Europe"; // Initialize a region string
        String expected = "FROM City c WHERE c.id = c.country.capital.id AND c.country.region = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.REGION_DESC.getQuery());
    }

    @Test
    void testQueryCityWorldDesc() {
        String expected = "FROM City c ORDER BY population DESC";
        Assertions.assertEquals(expected,Query.City.WORLD_DESC.getQuery());
    }

    @Test
    void testQueryCityContinentDesc() {
        String continent = "Asia"; // Initialize a continent string
        String expected = "FROM City c WHERE c.country.continent = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.CONTINENT_DESC.getQuery());
    }

    @Test
    void testQueryCityCountryDesc() {
        String country = "China"; // Initialize a country string
        String expected = "FROM City c WHERE c.country.name = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.COUNTRY_DESC.getQuery());
    }

    @Test
    void testQueryCityRegionDesc() {
        String region = "East Asia"; // Initialize a region string
        String expected = "FROM City c WHERE c.country.region = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.REGION_DESC.getQuery());
    }

    @Test
    void testQueryCityDistrictDesc() {
        String district = "Pudong"; // Initialize a district string
        String expected = "FROM City c WHERE c.district = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.City.DISTRICT_DESC.getQuery());
    }

    @Test
    void testQueryCountryWorldDesc() {
        String expected = "From Country c ORDER BY population DESC";
        Assertions.assertEquals(expected, Query.Country.WORLD_DESC.getQuery());
    }

    @Test
    void testQueryCountryContinentDesc() {
        String continent = "Africa"; // Initialize a continent string
        String expected = "FROM Country c WHERE c.continent = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.Country.CONTINENT_DESC.getQuery());
    }

    @Test
    void testQueryCountryRegionDesc() {
        String region = "Northern Africa"; // Initialize a region string
        String expected = "FROM Country c WHERE c.region = '%s' ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.Country.REGION_DESC.getQuery());
    }
}