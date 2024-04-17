package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBReader {
    private static SessionFactory sessionFactory = null;

    public static void initSession(String configFile, String ... connectionUrl) {
        if (sessionFactory == null) {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                Configuration configuration = new Configuration().configure(configFile);
                if (connectionUrl.length == 1) {
                    configuration.setProperty("hibernate.connection.url", connectionUrl[0]);
                }
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
    }

    // Method for queries that return ORM entities
    public static <T> List<T> queryDB(QueryString query, int limit, String... queryParam) {
        String hqlQuery = query.getQuery();
        if(queryParam.length == 1) {
            int count = hqlQuery.split("%s", -1).length - 1;
            String[] queryArgs = new String[count];
            Arrays.fill(queryArgs, queryParam[0]);
            hqlQuery = String.format(hqlQuery, queryArgs);
        } else if (queryParam.length > 1) {
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

    // Method for non-entity queries
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
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }
}