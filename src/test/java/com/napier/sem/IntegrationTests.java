package com.napier.sem;
import org.hibernate.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

public class IntegrationTests {
    @BeforeAll
    static void init() {
        DBReader.initSession("hibernate-integration.cfg.xml");
    }

    @Test
    void testQueryCapCity() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, 10);
        assert c != null;
        Assertions.assertEquals("Seoul", c.get(0).getName());
        Assertions.assertEquals("Lima", c.get(9).getName());

        c = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, 10, Continent.Asia.name());
        assert c != null;
        Assertions.assertEquals("Seoul", c.get(0).getName());
        Assertions.assertEquals("Rangoon (Yangon)", c.get(9).getName());

        c = DBReader.queryDB(Query.CapitalCity.REGION_DESC, 10, "Caribbean");
        assert c != null;
        Assertions.assertEquals("La Habana", c.get(0).getName());
        Assertions.assertEquals("Saint John´s", c.get(9).getName());
    }

    @Test
    void testQueryCity() {
        List<City> c = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, 10);
        assert c != null;
        Assertions.assertEquals("China", c.get(0).getName());
        Assertions.assertEquals("New York", c.get(9).getName());

        c = DBReader.queryDB(Query.City.CONTINENT_DESC, 10, Continent.Asia.name());
        assert c != null;
        Assertions.assertEquals("Mumbai (Bombay)", c.get(0).getName());
        Assertions.assertEquals("Teheran", c.get(9).getName());

        c = DBReader.queryDB(Query.City.COUNTRY_DESC, 10, "France");
        assert c != null;
        Assertions.assertEquals("Paris", c.get(0).getName());
        Assertions.assertEquals("Rennes", c.get(9).getName());

        c = DBReader.queryDB(Query.City.REGION_DESC, 10, "Polynesia");
        assert c != null;
        Assertions.assertEquals("Apia", c.get(0).getName());
        Assertions.assertEquals("Alofi", c.get(9).getName());

        c = DBReader.queryDB(Query.City.DISTRICT_DESC, 10, "Rajasthan");
        assert c != null;
        Assertions.assertEquals("Jaipur", c.get(0).getName());
        Assertions.assertEquals("Bharatpur", c.get(9).getName());
    }

    @Test
    void testQueryCountry() {
        List<Country> c = DBReader.queryDB(Query.Country.WORLD_DESC, 10);
        assert c != null;
        Assertions.assertEquals("China", c.get(0).getName());
        Assertions.assertEquals("Nigeria", c.get(9).getName());

        c = DBReader.queryDB(Query.Country.CONTINENT_DESC, 10, Continent.Asia.name());
        assert c != null;
        Assertions.assertEquals("China", c.get(0).getName());
        Assertions.assertEquals("Turkey", c.get(9).getName());

        c = DBReader.queryDB(Query.Country.REGION_DESC, 10, "Western Europe");
        assert c != null;
        Assertions.assertEquals("Germany", c.get(0).getName());
        Assertions.assertEquals("Liechtenstein", c.get(9).getName());
    }

    @Test
    void testLanguage() {
        List<Object[]> languageSpeakers = DBReader.queryDBNonEntity(Query.Language.LANGUAGE_DESC, 10, "");
        Assertions.assertEquals("Chinese", ((String) languageSpeakers.get(0)[0]));
        Assertions.assertEquals(1191843539, ((Double) languageSpeakers.get(0)[1]));
        Assertions.assertEquals(19.6067225, ((Double) languageSpeakers.get(0)[2]));
        Assertions.assertEquals("Punjabi", ((String) languageSpeakers.get(9)[0]));
        Assertions.assertEquals(104025371, ((Double) languageSpeakers.get(9)[1]));
        Assertions.assertEquals(1.7112955, ((Double) languageSpeakers.get(9)[2]));
    }


}
