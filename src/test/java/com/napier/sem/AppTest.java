package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    static Main app;
    @BeforeAll
    static void init() {
        app = new Main();
    }

    @Test
    void country_report_for_world_test_negative_limit() {
        DBReader.queryCountries(Query.Country.getWorldDesc(), -1);
    }
    @Test
    void city_report_for_world_test_negative_limit() {
        DBReader.queryCities(Query.Country.getWorldDesc(), -1);
    }

    @Test
    void testQueryCapitalCityWorldDesc() {
        String expected = "FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC";
        Assertions.assertEquals(expected, Query.CapitalCity.getWorldDesc());
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