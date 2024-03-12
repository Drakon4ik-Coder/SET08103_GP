package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.QueryArgumentException;

import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Check if -d command line argument is provided
            String configFile = "hibernate_local.cfg.xml";
            try {
                if (System.getProperty("command-line-argument").equals("-d")) {
                    configFile = "hibernate.cfg.xml";
                }
            }
            catch (NullPointerException e) {
                configFile = "hibernate_local.cfg.xml";
            }
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure(configFile).buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static List<Country> queryCountries(String hqlQuery, int limit, Object parameter, String parameterType) {
        List<Country> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            if (limit > 0) {
                if (parameter == null) {
                    results = session.createQuery(hqlQuery, Country.class)
                            .setMaxResults(limit)
                            .list();
                }
                else {
                    results = session.createQuery(hqlQuery, Country.class)
                            .setParameter(parameterType, parameter)
                            .setMaxResults(limit)
                            .list();
                }
            }
            else {
                if (parameter == null) {
                    results = session.createQuery(hqlQuery, Country.class)
                            .list();
                }
                else {
                    results = session.createQuery(hqlQuery, Country.class)
                            .setParameter(parameterType, parameter)
                            .list();
                }
            }
            session.getTransaction().commit();
        }
        catch (QueryArgumentException e) {
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<City> queryCities(String hqlQuery, int limit, String parameter, String parameterType) {
        List<City> results = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            if (limit > 0) {
                if (parameter == null) {
                    results = session.createQuery(hqlQuery, City.class)
                            .setMaxResults(limit)
                            .list();
                }
                else {
                    results = session.createQuery(hqlQuery, City.class)
                            .setParameter(parameterType, parameter)
                            .setMaxResults(limit)
                            .list();
                }
            }
            else {
                if (parameter == null) {
                    results = session.createQuery(hqlQuery, City.class)
                            .list();
                }
                else {
                    results = session.createQuery(hqlQuery, City.class)
                            .setParameter(parameterType, parameter)
                            .list();
                }
            }
            session.getTransaction().commit();
        }
        catch (QueryArgumentException e) {
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }


}