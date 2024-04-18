package com.napier.sem;

import lombok.Getter;

/*
 * QueryString class
 * stores all the info about the sql query
 */
public class QueryString {
    @Getter
    private String query;
    @Getter
    private QueryType type;
    private QueryString(){}

    public QueryString(String queryString, QueryType queryType) {
        query=queryString;
        type=queryType;
    }

}
