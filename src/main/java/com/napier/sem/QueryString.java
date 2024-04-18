package com.napier.sem;

import lombok.Getter;

/**
 * Class to represent a QueryString, which contains a query and its type
 */
public class QueryString {
    /**
     * A private field to store the query string
     */
    @Getter
    private String query;

    /**
     * A private field to store the type of the query
     */
    @Getter
    private QueryType type;

    /**
     * A private constructor to enforce the use of the parameterized constructor
     */
    private QueryString(){}

    /**
     * A parameterized constructor to initialize the query and its type
     * @param queryString The query string to be stored
     * @param queryType The type of the query to be stored
     */
    public QueryString(String queryString, QueryType queryType) {
        query=queryString;
        type=queryType;
    }

}
