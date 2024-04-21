package com.napier.sem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.List;
import static spark.Spark.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        // Disable logging for the application, only show severe errors
        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
        // Initialize the database session with hibernate configuration file
        // If the first argument is "DEBUG", then initialize the session with a specific JDBC URL
        if(args.length!=0 && args[0].equals("DEBUG")) {
            DBReader.initSession("hibernate.cfg.xml", "jdbc:mysql://localhost:3306/world");
        } else {
            DBReader.initSession("hibernate.cfg.xml");
        }
        port(8080);
        staticFiles.location("/public");
        get("/", (req, res) -> {
            // Redirect to index.html
            res.redirect("index.html");
            return null;
        });

        get("/report", (req, res) -> {
            String reportName = req.queryParams("name");
            int reportLimit = req.queryParams("limit") != null ? Integer.parseInt(req.queryParams("limit")) : 0;
            String addParam = req.queryParams("param");

            switch (reportName) {
                case "CapitalWorld": {
                    String ret = "";
                    List<City> capCities = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, reportLimit, addParam);
                    if (capCities != null && !capCities.isEmpty()) {
                        for (City capCity : capCities) {
                            ret += capCity.toStringCapital() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CapitalContinent": {
                    String ret = "";
                    List<City> capCities = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, reportLimit, addParam);
                    System.out.println(capCities);
                    if (capCities != null && !capCities.isEmpty()) {
                        for (City capCity : capCities) {
                            ret += capCity.toStringCapital() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CapitalRegion": {
                    String ret = "";
                    List<City> capCities = DBReader.queryDB(Query.CapitalCity.REGION_DESC, reportLimit, addParam);
                    if (capCities != null && !capCities.isEmpty()) {
                        for (City capCity : capCities) {
                            ret += capCity.toStringCapital() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CountryWorld": {
                    String ret = "";
                    List<Country> countries = DBReader.queryDB(Query.Country.WORLD_DESC, reportLimit, addParam);
                    if (countries != null && !countries.isEmpty()) {
                        for (Country country : countries) {
                            ret += country.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CountryContinent": {
                    String ret = "";
                    List<Country> countries = DBReader.queryDB(Query.Country.CONTINENT_DESC, reportLimit, addParam);
                    if (countries != null && !countries.isEmpty()) {
                        for (Country country : countries) {
                            ret += country.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CountryRegion": {
                    String ret = "";
                    List<Country> countries = DBReader.queryDB(Query.Country.REGION_DESC, reportLimit, addParam);
                    if (countries != null && !countries.isEmpty()) {
                        for (Country country : countries) {
                            ret += country.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                //Population--------------------------------------------------------------------------------------------
                case "PopulationWorld": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.WORLD, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "PopulationContinent": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.CONTINENT, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "PopulationCountry": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.COUNTRY, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "PopulationRegion": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.REGION, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "PopulationDistrict": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.DISTRICT, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "PopulationCity": {
                    String ret = "";
                    List<Population> populations = DBReader.queryDB(Query.Population.CITY, reportLimit, addParam);
                    if (populations != null && !populations.isEmpty()) {
                        for (Population population : populations) {
                            ret += population.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                //City--------------------------------------------------------------------------------------------------
                case "CityWorld": {
                    String ret = "";
                    List<City> cities = DBReader.queryDB(Query.City.WORLD_DESC, reportLimit, addParam);
                    if (cities != null && !cities.isEmpty()) {
                        for (City city : cities) {
                            ret += city.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CityContinent": {
                    String ret = "";
                    List<City> cities = DBReader.queryDB(Query.City.CONTINENT_DESC, reportLimit, addParam);
                    if (cities != null && !cities.isEmpty()) {
                        for (City city : cities) {
                            ret += city.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CityCountry": {
                    String ret = "";
                    List<City> cities = DBReader.queryDB(Query.City.COUNTRY_DESC, reportLimit, addParam);
                    if (cities != null && !cities.isEmpty()) {
                        for (City city : cities) {
                            ret += city.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CityRegion": {
                    String ret = "";
                    List<City> cities = DBReader.queryDB(Query.City.REGION_DESC, reportLimit, addParam);
                    if (cities != null && !cities.isEmpty()) {
                        for (City city : cities) {
                            ret += city.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
                case "CityDistrict": {
                    String ret = "";
                    List<City> cities = DBReader.queryDB(Query.City.DISTRICT_DESC, reportLimit, addParam);
                    if (cities != null && !cities.isEmpty()) {
                        for (City city : cities) {
                            ret += city.toString() + "\n";
                        }
                    } else {
                        ret = "Nothing found";
                    }
                    return ret;
                }
            }
            return "No such report supported";
        });
//--Capital City
//        System.out.println("World capital city population descending:");
//        List<City> capCities = DBReader.queryDB(Query.CapitalCity.WORLD_DESC, 10);
//        for (City capCity : capCities) {
//            System.out.println(capCity.toStringCapital());
//        }
//        System.out.println("\nAsian continent capital city population descending:");
//        capCities = DBReader.queryDB(Query.CapitalCity.CONTINENT_DESC, 10, Continent.Asia.name());
//        for (City capCity : capCities) {
//            System.out.println(capCity.toStringCapital());
//        }
//        System.out.println("\nCaribbean region capital city population descending:");
//        capCities = DBReader.queryDB(Query.CapitalCity.REGION_DESC, 10, "Caribbean");
//        for (City capCity : capCities) {
//            System.out.println(capCity.toStringCapital());
//        }
////--City
//        System.out.println("\nWorld city population descending:");
//        List<City> citiesWorld = DBReader.queryDB(Query.City.WORLD_DESC, 10);
//        for (City city : citiesWorld) {
//            System.out.println(city.toString());
//        }
//        System.out.println("\nAsian continent city population descending:");
//        List<City> citiesContinent = DBReader.queryDB(Query.City.CONTINENT_DESC, 10, Continent.Asia.name());
//        for (City city : citiesContinent) {
//            System.out.println(city.toString());
//        }
//        System.out.println("\nFrance city population descending:");
//        List<City> citiesCountry = DBReader.queryDB(Query.City.COUNTRY_DESC, 10, "France");
//        for (City city : citiesCountry) {
//            System.out.println(city.toString());
//        }
//        System.out.println("\nPolynesia region population descending:");
//        List<City> citiesRegion = DBReader.queryDB(Query.City.REGION_DESC, 10, "Polynesia");
//        for (City city : citiesRegion) {
//            System.out.println(city.toString());
//        }
//        System.out.println("\nRajasthan district population descending:");
//        List<City> citiesDistrict = DBReader.queryDB(Query.City.DISTRICT_DESC, 10, "Rajasthan");
//        for (City city : citiesDistrict) {
//            System.out.println(city.toString());
//        }
////--Country
//        System.out.println("\nWorld country population descending:");
//        List<Country> Countries = DBReader.queryDB(Query.Country.WORLD_DESC, 10);
//        for (Country c : Countries) {
//            System.out.println(c.toString());
//        }
//        System.out.println("\nAsian continent country population descending:");
//        Countries = DBReader.queryDB(Query.Country.CONTINENT_DESC, 10, Continent.Asia.name());
//        for (Country c : Countries) {
//            System.out.println(c.toString());
//        }
//        System.out.println("\nWestern Europe region country population descending:");
//        Countries = DBReader.queryDB(Query.Country.REGION_DESC, 10, "Western Europe");
//        for (Country c : Countries) {
//            System.out.println(c.toString());
//        }
//
////--Language
//        System.out.println("\nLanguage report with the number of speakers and percentage of world population (in descending order):");
//        List<Object[]> languageSpeakers = DBReader.queryDBNonEntity(Query.Language.LANGUAGE_DESC, 0, "");
//        for (Object[] row : languageSpeakers) {
//            String language = (String) row[0];
//            // Filter the results
//            if (language.equals("Chinese") || language.equals("English") || language.equals("Hindi") || language.equals("Spanish") || language.equals("Arabic")) {
//                Double totalSpeakers = (Double) row[1];
//                Double percentageOfWorldPopulation = (Double) row[2];
//                System.out.printf("%s: %d speakers (%.2f%% of world population)\n", language, totalSpeakers.intValue(), percentageOfWorldPopulation);
//            }
//        }
//
////--Population
//        System.out.println("\nPopulation report:");
//        List<Population> Populations = DBReader.queryDB(Query.Population.WORLD, 0);
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//        Populations = DBReader.queryDB(Query.Population.CONTINENT, 0, "Asia");
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//        Populations = DBReader.queryDB(Query.Population.COUNTRY, 0, "Ukraine");
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//        Populations = DBReader.queryDB(Query.Population.REGION, 0, "Western Europe");
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//        Populations = DBReader.queryDB(Query.Population.DISTRICT, 0, "Kiova");
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//        Populations = DBReader.queryDB(Query.Population.CITY, 0, "Kyiv");
//        for (Population p : Populations) {
//            System.out.println(p.toString());
//        }
//
    }
}

