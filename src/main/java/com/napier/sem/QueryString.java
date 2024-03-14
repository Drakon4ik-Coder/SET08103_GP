package com.napier.sem;

import lombok.Getter;

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
