package com.napier.sem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hibernate.query.Query;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    private static SessionFactory sessionFactory = null;

    @BeforeAll
    static void init() {
        DBReader.initSession("hibernate-integration.cfg.xml");
        HibernateUtil.shutdown();
        Configuration configuration = new Configuration().configure("hibernate-integration.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Test
    public void testDatabaseConnection() {
        Assertions.assertDoesNotThrow(() -> {
            Configuration configuration = new Configuration().configure("hibernate-integration.cfg.xml");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306");
            configuration.buildSessionFactory();
            HibernateUtil.shutdown();
        });
    }

    @Test
    public void testDatabasePresence() {
        Assertions.assertDoesNotThrow(() -> {
            DBReader.initSession("hibernate-integration.cfg.xml");
            HibernateUtil.shutdown();
        });
    }

    @Test
    public void testCityTablePresenceAndStructure() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNativeQuery("SELECT * FROM city");
            List<Object[]> cityRows = query.list();
            assertFalse(cityRows.isEmpty(), "City table is empty");
            for (Object[] row : cityRows) {
                assertEquals(5, row.length, "Incorrect number of columns in City table");
                assertTrue(row[0] instanceof Integer, "ID column should be an Integer");
                assertTrue(row[1] instanceof String, "Name column should be a String");
                assertTrue(row[2] instanceof String, "CountryCode column should be a String");
                assertTrue(row[3] instanceof String, "District column should be a String");
                assertTrue(row[4] instanceof Integer, "Population column should be an Integer");
            }
            transaction.commit();
        } catch (Exception ex) {
            fail("Failed to check City table presence and structure: " + ex.getMessage());
        }
    }

    @Test
    public void testCountryTablePresenceAndStructure() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createNativeQuery("SELECT * FROM country");
            List<Object[]> countryRows = query.list();
            assertFalse(countryRows.isEmpty(), "Country table is empty");
            for (Object[] row : countryRows) {
                assertEquals(15, row.length, "Incorrect number of columns in Country table");
                assertTrue(row[0] instanceof String, "Code column should be a String");
                assertTrue(row[1] instanceof String, "Name column should be a String");
                assertTrue(row[2] instanceof String, "Continent column should be a String");
                assertTrue(row[3] instanceof String, "Region column should be a String");
                assertTrue(row[4] instanceof BigDecimal, "SurfaceArea column should be a BigDecimal");
                assertTrue(row[5] == null || row[5] instanceof Short, "IndepYear column should be an Short or null");
                assertTrue(row[6] instanceof Integer, "Population column should be an Integer");
                assertTrue(row[7] == null || row[7] instanceof BigDecimal, "LifeExpectancy column should be a BigDecimal or null");
                assertTrue(row[8] == null || row[8] instanceof BigDecimal, "GNP column should be a BigDecimal or null");
                assertTrue(row[9] == null || row[9] instanceof BigDecimal, "GNPOld column should be a BigDecimal or null");
                assertTrue(row[10] instanceof String, "LocalName column should be a String");
                assertTrue(row[11] instanceof String, "GovernmentForm column should be a String");
                assertTrue(row[12] == null || row[12] instanceof String, "HeadOfState column should be a String or null");
                assertTrue(row[13] == null || row[13] instanceof Integer, "Capital column should be an Integer or null");
                assertTrue(row[14] instanceof String, "Code2 column should be a String");
            }
            transaction.commit();
        } catch (Exception ex) {
            fail("Failed to check country table presence and structure: " + ex.getMessage());
        }
    }


}
