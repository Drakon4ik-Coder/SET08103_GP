package com.napier.sem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for reading data from the database using Hibernate.
 */
public class DBReader {
    private static SessionFactory sessionFactory = null;

    /**
     * Initializes the SessionFactory with the given configuration file and connection URL.
     * @param configFile The path to the Hibernate configuration file.
     * @param connectionUrl The connection URL for the database.
     */
    public static void initSession(String configFile, String... connectionUrl) {
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

    /**
     * Executes a query that returns ORM entities.
     * @param query The QueryString object containing the HQL query and its type.
     * @param limit The maximum number of results to return.
     * @param queryParam The parameter(s) to be used in the query.
     * @return A list of ORM entities.
     */
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

    /**
     * Executes a query that returns non-entity results.
     * @param query The QueryString object containing the HQL query.
     * @param limit The maximum number of results to return.
     * @param queryParam The parameter(s) to be used in the query.
     * @return A list of non-entity results.
     */
    public static List<Object[]> queryDBNonEntity(QueryString query, int limit, String... queryParam) {
        String hqlQuery = query.getQuery();
        if (queryParam.length!= 0) {
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