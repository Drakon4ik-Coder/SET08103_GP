package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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

    public static <T> List<T> queryDB(QueryString query, int limit, String... queryParam) {
        String hqlQuery = query.getQuery();
        if (queryParam.length != 0) {
            hqlQuery = String.format(hqlQuery, queryParam);
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<T> results = session.createQuery(hqlQuery, query.getType().queryClass);
            if (limit > 0) {
                results = results.setMaxResults(limit);
            }
            session.getTransaction().commit();
            return results.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Object[]> queryDBNonEntity(QueryString query, int limit, String... queryParam) {
        String hqlQuery = query.getQuery();
        if (queryParam.length != 0) {
            hqlQuery = String.format(hqlQuery, queryParam);
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Object[]> results = session.createQuery(hqlQuery);
            if (limit > 0) {
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