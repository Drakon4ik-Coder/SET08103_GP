package com.napier.sem;

import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.query.QueryArgumentException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {

        // Check if -d command line argument is provided (used for Docker deployment, assumes test configuration without the -d argument)
        if (args.length > 0 && args[0].equals("-d")) {
            System.setProperty("command-line-argument", "-d");
            // Disable hibernate warnings in deploy mode
            LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Enter:\n1 - Display the countries in the world by population\n2 - Display the countries in a continent organised by population\n3 - Display the countries in a region organised by population\nexit - Quit the program");
                String input = reader.readLine();
                int limit = 0;
                switch (input) {
                    case "1":
                        // Country Report for world & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        List<Country> topPopulatedCountries = getTopPopulatedCountries(limit);
                        if (topPopulatedCountries.size() != 0) {
                            for (Country country : topPopulatedCountries) {
                                try {
                                    System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                                }
                                catch (NullPointerException ignored) {}
                            }
                        }
                        else {
                            System.out.println("No entries found");
                        }
                        break;
                    case "2":
                        // Country Report for continent & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the continent name: ");
                        String continent1 = reader.readLine();
                        List<Country> topPopulatedCountriesInContinent = getTopPopulatedCountriesInContinent(limit, continent1);
                        if (topPopulatedCountriesInContinent.size() != 0) {
                            for (Country country : topPopulatedCountriesInContinent) {
                                try {
                                    System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                                }
                                catch (NullPointerException ignored) {}
                            }
                        }
                        else {
                            System.out.println("No entries found");
                        }
                        break;
                    case "3":
                        // Country report for region & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the region name: ");
                        String region1 = reader.readLine();
                        List<Country> topPopulatedCountriesInRegion = getTopPopulatedCountriesInRegion(limit, region1);
                        if (topPopulatedCountriesInRegion.size() != 0) {
                            for (Country country : topPopulatedCountriesInRegion) {
                                try {
                                    System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                                }
                                catch (NullPointerException ignored) {}
                            }
                        }
                        else {
                            System.out.println("No entries found");
                        }
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println("Error: invalid input");
                        break;
                }
            }
            catch (IOError e) {
                throw new RuntimeException(e);
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
            catch (HibernateException e) {
                System.out.println("Database connection error");
                break;
            }
            catch (Exception e) {
                //System.out.println("Database error");
                e.printStackTrace();
            }
        }

    }

    public static List<Country> getTopPopulatedCountries(int limit) {
        try {
            String hqlQuery = "FROM Country ORDER BY population DESC";
            return DBReader.queryCountries(hqlQuery, limit, null, null);
        }
        catch (Exception e) {
            //System.out.println("Error");
            e.printStackTrace();
            return new ArrayList<Country>();
        }
    }

    public static List<Country> getTopPopulatedCountriesInContinent(int limit, String continent) {
        try {
            String hqlQuery = "FROM Country WHERE continent = :continent ORDER BY population DESC";
            return DBReader.queryCountries(hqlQuery, limit, Continent.fromString(continent), "continent");
        }
        catch (QueryArgumentException e) {
            System.out.println("Error: invalid continent name");
            return new ArrayList<Country>();
        }
        catch (Exception e) {
            //System.out.println("Error");
            e.printStackTrace();
            return new ArrayList<Country>();
        }
    }

    public static List<Country> getTopPopulatedCountriesInRegion(int limit, String region) {
        try {
            String hqlQuery = "FROM Country WHERE region = :region ORDER BY population DESC";
            return DBReader.queryCountries(hqlQuery, limit, region, "region");
        }
        catch (QueryArgumentException e) {
            System.out.println("Error: invalid region name");
            return new ArrayList<Country>();
        }
        catch (Exception e) {
            //System.out.println("Error");
            e.printStackTrace();
            return new ArrayList<Country>();
        }
    }

}

