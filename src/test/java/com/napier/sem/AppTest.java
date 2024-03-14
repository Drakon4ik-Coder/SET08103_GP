package com.napier.sem;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    void country_report_for_world_test_limit() {
        List<Country> l = DBReader.queryCountries(Query.Country.getWorldDesc(), 10);
        Assertions.assertEquals(10, l.size());
    }

    @Test
    void country_report_for_continent_test_negative_limit() {
        DBReader.queryCountries(Query.Country.getContinentDesc("Asia"), -1);
    }

    @Test
    void country_report_for_continent_test_limit() {
        DBReader.queryCountries(Query.Country.getContinentDesc("Asia"), 10);
    }

    @Test
    void country_report_for_continent_test_invalid_continent() {
        DBReader.queryCountries(Query.Country.getContinentDesc("a"), 10);
    }

    @Test
    void country_report_for_region_test_negative_limit() {
        DBReader.queryCountries(Query.Country.getRegionDesc("Western Europe"), -1);
    }

    @Test
    void country_report_for_region_test_limit() {
        DBReader.queryCountries(Query.Country.getRegionDesc("Western Europe"), 10);
    }

    @Test
    void country_report_for_continent_test_invalid_region() {
        DBReader.queryCountries(Query.Country.getRegionDesc("a"), 10);
    }
}
