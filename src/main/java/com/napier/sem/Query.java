package com.napier.sem;

abstract class Query {
    private Query(){

    }
    abstract static class CapitalCity {
        public static final QueryString WORLD_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC", QueryType.CAPITAL_CITY);
        public static final QueryString CONTINENT_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id AND c.country.continent = '%s' ORDER BY c.population DESC", QueryType.CAPITAL_CITY);
        public static final QueryString REGION_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id AND c.country.region = '%s' ORDER BY c.population DESC", QueryType.CAPITAL_CITY);
    }
    abstract static class City {
        public static final QueryString WORLD_DESC = new QueryString("FROM City c ORDER BY population DESC", QueryType.CITY);
        public static final QueryString CONTINENT_DESC = new QueryString("FROM City c WHERE c.country.continent = '%s' ORDER BY c.population DESC", QueryType.CITY);
        public static final QueryString COUNTRY_DESC = new QueryString("FROM City c WHERE c.country.name = '%s' ORDER BY c.population DESC", QueryType.CITY);
        public static final QueryString REGION_DESC = new QueryString("FROM City c WHERE c.country.region = '%s' ORDER BY c.population DESC", QueryType.CITY);
        public static final QueryString DISTRICT_DESC = new QueryString("FROM City c WHERE c.district = '%s' ORDER BY c.population DESC", QueryType.CITY);

    }

    abstract static class Country {
        public static final QueryString WORLD_DESC = new QueryString("From Country c ORDER BY population DESC", QueryType.COUNTRY);
        public static final QueryString CONTINENT_DESC = new QueryString("FROM Country c WHERE c.continent = '%s' ORDER BY c.population DESC", QueryType.COUNTRY);
        public static final QueryString REGION_DESC = new QueryString("FROM Country c WHERE c.region = '%s' ORDER BY c.population DESC", QueryType.COUNTRY);
    }

    abstract static class Language {
        public static final QueryString LANGUAGE_DESC = new QueryString(
                "SELECT cli.id.language, SUM(cli.percentage * c.population / 100) AS totalSpeakers, " +
                        "(SUM(cli.percentage * c.population / 100) / (SELECT SUM(c2.population) FROM Country c2)) * 100 AS percentageOfWorldPopulation " +
                        "FROM CountryLanguage cli " +
                        "JOIN Country c ON cli.id.countryCode = c.code " +
                        "GROUP BY cli.id.language " +
                        "ORDER BY totalSpeakers DESC", QueryType.LANGUAGE);

    }


}