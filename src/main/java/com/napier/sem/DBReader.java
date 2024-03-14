package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static List<Country> queryCountries(String hqlQuery, int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Country> results = session.createQuery(hqlQuery, Country.class);
            if (limit > 0)
            {
                results = results.setMaxResults(limit);
            }
            session.getTransaction().commit();
            return results.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<City> queryCities(String hqlQuery, int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<City> results = session.createQuery(hqlQuery, City.class);
            if (limit > 0)
            {
                results = results.setMaxResults(limit);
            }
            session.getTransaction().commit();
            return results.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}