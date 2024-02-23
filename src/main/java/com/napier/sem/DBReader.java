package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        List<Country> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            results = session.createQuery(hqlQuery, Country.class)
                    .setMaxResults(limit)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<City> queryCities(String hqlQuery, int limit) {
        List<City> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            results = session.createQuery(hqlQuery, City.class)
                    .setMaxResults(limit)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    public static List<CapitalCity> queryCapitalCities(String hqlQuery, int limit) {
        List<CapitalCity> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            results = session.createQuery(hqlQuery, CapitalCity.class)
                    .setMaxResults(limit)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}