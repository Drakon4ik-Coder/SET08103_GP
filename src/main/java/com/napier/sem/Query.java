package com.napier.sem;

/**
 * Abstract class representing a query.
 */
abstract class Query {
    /**
     * Private constructor to prevent instantiation.
     */
    private Query(){

    }

    /**
     * Abstract class representing queries for capital cities.
     */
    abstract static class CapitalCity {
        /**
         * Query to get all capital cities in the world in descending order of population.
         */
        public static final QueryString WORLD_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC", QueryType.CAPITAL_CITY);

        /**
         * Query to get all capital cities in a given continent in descending order of population.
         * @param continent The continent to filter by.
         */
        public static final QueryString CONTINENT_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id AND c.country.continent = '%s' ORDER BY c.population DESC", QueryType.CAPITAL_CITY);

        /**
         * Query to get all capital cities in a given region in descending order of population.
         * @param region The region to filter by.
         */
        public static final QueryString REGION_DESC = new QueryString("FROM City c WHERE c.id = c.country.capital.id AND c.country.region = '%s' ORDER BY c.population DESC", QueryType.CAPITAL_CITY);
    }

    /**
     * Abstract class representing queries for cities.
     */
    abstract static class City {
        /**
         * Query to get all cities in the world in descending order of population.
         */
        public static final QueryString WORLD_DESC = new QueryString("FROM City c ORDER BY population DESC", QueryType.CITY);

        /**
         * Query to get all cities in a given continent in descending order of population.
         * @param continent The continent to filter by.
         */
        public static final QueryString CONTINENT_DESC = new QueryString("FROM City c WHERE c.country.continent = '%s' ORDER BY c.population DESC", QueryType.CITY);

        /**
         * Query to get all cities in a given country in descending order of population.
         * @param country The country to filter by.
         */
        public static final QueryString COUNTRY_DESC = new QueryString("FROM City c WHERE c.country.name = '%s' ORDER BY c.population DESC", QueryType.CITY);

        /**
         * Query to get all cities in a given region in descending order of population.
         * @param region The region to filter by.
         */
        public static final QueryString REGION_DESC = new QueryString("FROM City c WHERE c.country.region = '%s' ORDER BY c.population DESC", QueryType.CITY);

        /**
         * Query to get all cities in a given district in descending order of population.
         * @param district The district to filter by.
         */
        public static final QueryString DISTRICT_DESC = new QueryString("FROM City c WHERE c.district = '%s' ORDER BY c.population DESC", QueryType.CITY);
    }

    /**
     * Abstract class representing queries for countries.
     */
    abstract static class Country {
        /**
         * Query to get all countries in the world in descending order of population.
         */
        public static final QueryString WORLD_DESC = new QueryString("From Country c ORDER BY population DESC", QueryType.COUNTRY);

        /**
         * Query to get all countries in a given continent in descending order of population.
         * @param continent The continent to filter by.
         */
        public static final QueryString CONTINENT_DESC = new QueryString("FROM Country c WHERE c.continent = '%s' ORDER BY c.population DESC", QueryType.COUNTRY);

        /**
         * Query to get all countries in a given region in descending order of population.
         * @param region The region to filter by.
         */
        public static final QueryString REGION_DESC = new QueryString("FROM Country c WHERE c.region = '%s' ORDER BY c.population DESC", QueryType.COUNTRY);
    }

    /**
     * Abstract class representing queries for languages.
     */
    abstract static class Language {
        /**
         * Query to get information about languages spoken around the world.
         */
        public static final QueryString LANGUAGE_DESC = new QueryString(
                "SELECT cli.id.language, SUM(cli.percentage * c.population / 100) AS totalSpeakers, " +
                        "(SUM(cli.percentage * c.population / 100) / (SELECT SUM(c2.population) FROM Country c2)) * 100 AS percentageOfWorldPopulation " +
                        "FROM CountryLanguage cli " +
                        "JOIN Country c ON cli.id.countryCode = c.code " +
                        "GROUP BY cli.id.language " +
                        "ORDER BY totalSpeakers DESC", QueryType.LANGUAGE);

    }

    /**
     * Abstract class representing queries for population.
     */
    abstract static class Population {
        /**
         * Query to get the population ofthe world.
         */
        public static final QueryString WORLD = new QueryString("SELECT 'world' as reportName, r1.sum as total, r2.sum as city, r1.sum-r2.sum as notCity FROM (SELECT SUM(population) as sum FROM Country) r1, (SELECT SUM(population) as sum FROM City) r2", QueryType.POPULATION);

        /**
         * Query to get the population of a given continent.
         * @param continent The continent to filter by.
         */
        public static final QueryString CONTINENT = new QueryString("SELECT '%s' as reportName, r1.sum as total, r2.sum as city, r1.sum-r2.sum as notCity FROM (SELECT SUM(population) as sum FROM Country WHERE continent='%s') r1, (SELECT SUM(population) as sum FROM City WHERE country.continent='%s') r2", QueryType.POPULATION);
        public static final QueryString COUNTRY = new QueryString("SELECT '%s' as reportName, r1.sum as total, r2.sum as city, r1.sum-r2.sum as notCity FROM (SELECT SUM(population) as sum FROM Country WHERE name='%s') r1, (SELECT SUM(population) as sum FROM City WHERE country.name='%s') r2", QueryType.POPULATION);

        public static final QueryString REGION = new QueryString("SELECT '%s' as reportName, r1.sum as total, r2.sum as city, r1.sum-r2.sum as notCity FROM (SELECT SUM(population) as sum FROM Country WHERE region='%s') r1, (SELECT SUM(population) as sum FROM City WHERE country.region='%s') r2", QueryType.POPULATION);
        public static final QueryString DISTRICT = new QueryString("SELECT '%s' as reportName, r1.sum as total, r1.sum as city, -1 as notCity FROM (SELECT SUM(population) as sum FROM City WHERE district='%s') r1", QueryType.POPULATION);
        /**
         * Query to get the population of a given city.
         * @param city The city to filter by.
         */
        public static final QueryString CITY = new QueryString("SELECT '%s' as reportName, r1.population as total FROM City r1 WHERE r1.name='%s'", QueryType.POPULATION);
    }

}