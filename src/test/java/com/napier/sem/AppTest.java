package com.napier.sem;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {
    static Main app;

    @BeforeAll
    static void init()
    {
        app = new Main();
    }

    @Test
    void country_report_for_world_test_negative_limit() {
        Main.getTopPopulatedCountries(-1);
    }
    @Test
    void country_report_for_world_test_with_limit_normal() {
        List<Country> l = Main.getTopPopulatedCountries(2);
        Assertions.assertEquals(l.size(), 2);
    }
    @Test
    void country_report_for_world_test_normal() {
        Main.getTopPopulatedCountries(0);
    }
    @Test
    void country_report_for_continent_test_negative_limit() {
        Main.getTopPopulatedCountriesInContinent(-1, "Africa");
    }
    @Test
    void country_report_for_continent_test_null_parameter() {
        Main.getTopPopulatedCountriesInContinent(1, "");
    }
    @Test
    void country_report_for_continent_test_invalid_parameter() {
        Main.getTopPopulatedCountriesInContinent(0, "sfgfg");
    }
    @Test
    void country_report_for_continent_test_normal() {
        Main.getTopPopulatedCountriesInContinent(0, "Africa");
    }
    @Test
    void country_report_for_continent_test_with_limit_normal() {
        List<Country> l = Main.getTopPopulatedCountriesInContinent(2, "Africa");
        Assertions.assertEquals(l.size(), 2);
    }
    @Test
    void country_report_for_region_test_negative_limit() {
        Main.getTopPopulatedCountriesInRegion(-1, "North Africa");
    }
    @Test
    void country_report_for_region_test_null_parameter() {
        Main.getTopPopulatedCountriesInRegion(1, "");
    }
    @Test
    void country_report_for_region_test_invalid_parameter() {
        Main.getTopPopulatedCountriesInRegion(0, "sfgfg");
    }
    @Test
    void country_report_for_region_test_normal() {
        Main.getTopPopulatedCountriesInRegion(0, "Western Europe");
    }
    @Test
    void country_report_for_region_test_with_limit_normal() {
        List<Country> l = Main.getTopPopulatedCountriesInRegion(2, "Western Europe");
        Assertions.assertEquals(l.size(), 2);
    }
    @Test
    void continent_from_string_null() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Continent.fromString("");
                });
    }
    @Test
    void continent_from_string_invalid() {
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Continent.fromString("null");
                });
    }
    @Test
    void continent_from_string_lowercase_with_space() {
        Continent c = Continent.fromString("north america");
        Assertions.assertEquals(c, Continent.NorthAmerica);
    }
    @Test
    void convertToDatabaseColumn_null() {
        ContinentEnumConverter conv = new ContinentEnumConverter();
        var c = conv.convertToDatabaseColumn(null);
        Assertions.assertNull(c);
    }
    @Test
    void convertToDatabaseColumn_normal() {
        ContinentEnumConverter conv = new ContinentEnumConverter();
        String c = conv.convertToDatabaseColumn(Continent.Africa);
        Assertions.assertEquals(c, "Africa");
    }
    @Test
    void convertToEntityAttribute_null() {
        ContinentEnumConverter conv = new ContinentEnumConverter();
        var c = conv.convertToEntityAttribute(null);
        Assertions.assertNull(c);
    }
    @Test
    void convertToEntityAttribute_invalid() {
        ContinentEnumConverter conv = new ContinentEnumConverter();
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Continent c = conv.convertToEntityAttribute("sdfdsf");
                });
    }
    @Test
    void convertToEntityAttribute_normal() {
        ContinentEnumConverter conv = new ContinentEnumConverter();
        Continent c = conv.convertToEntityAttribute("Asia");
        Assertions.assertEquals(c, Continent.Asia);
    }

}
