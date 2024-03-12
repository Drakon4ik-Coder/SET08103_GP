package com.napier.sem;

public class Query {
    private Query(){

    }
    public static class CapitalCity {
        private static String WORLD_DESC = "FROM City c WHERE c.id = c.country.capital.id ORDER BY c.population DESC";
        private static String CONTINENT_DESC = "FROM City c WHERE c.id = c.country.capital.id AND c.country.continent = '%s' ORDER BY c.population DESC";
        private static String REGION_DESC = "FROM City c WHERE c.id = c.country.capital.id AND c.country.region = '%s' ORDER BY c.population DESC";

        public static String getWorldDesc(){
            return WORLD_DESC;
        }
        public static String getContinentDesc(String continent){
            return String.format(CONTINENT_DESC, continent);
        }

        public static String getRegionDesc(String region){
            return String.format(REGION_DESC, region);
        }
    }
}