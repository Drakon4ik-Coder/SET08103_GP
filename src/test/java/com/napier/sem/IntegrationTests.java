package com.napier.sem;
import org.eclipse.jetty.websocket.common.events.AbstractEventDriver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.hibernate.query.Query;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

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

}
