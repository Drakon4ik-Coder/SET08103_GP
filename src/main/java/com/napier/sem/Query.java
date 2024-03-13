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
        public static String getContinentDesc(Continent continent){
            return String.format(CONTINENT_DESC, continent);
        }

        public static String getRegionDesc(String region){
            return String.format(REGION_DESC, region);
        }
    }
    public static class City {
        private static String WORLD_DESC = "FROM City c ORDER BY population DESC";
        private static String CONTINENT_DESC = "FROM City c WHERE c.country.continent = '%s' ORDER BY c.population DESC";
        private static String COUNTRY_DESC = "FROM City c WHERE c.country.name = '%s' ORDER BY c.population DESC";
        private static String REGION_DESC = "FROM City c WHERE c.country.region = '%s' ORDER BY c.population DESC";
        private static String DISTRICT_DESC = "FROM City c WHERE c.country.district = '%s' ORDER BY c.population DESC";
        public static String getWorldDesc() {
            return WORLD_DESC;
        }

        public static String getContinentDesc(String continent) {
            return String.format(CONTINENT_DESC, continent);
        }

        public static String getCountryDesc(String country) {
            return String.format(COUNTRY_DESC, country);
        }

        public static String getRegionDesc(String region){
            return String.format(REGION_DESC, region);
        }

        public static String getDistrictDesc(String district){
            return String.format(DISTRICT_DESC, district);
        }

    }


}