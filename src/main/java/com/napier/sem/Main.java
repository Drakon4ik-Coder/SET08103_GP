package com.napier.sem;

import org.hibernate.HibernateException;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter:\n1 - Display the countries in the world by population\n2 - Display the countries in a continent organised by population\n3 - Display the countries in a region organised by population\nexit - Quit the program");
            try {
                String input = reader.readLine();
                int limit = 0;
                switch (input) {
                    case "1":
                        // Country Report for world & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        List<Country> topPopulatedCountries = getTopPopulatedCountries(limit);
                        for (Country country : topPopulatedCountries) {
                            try {
                                System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                            }
                            catch (NullPointerException e) {
                                continue;
                            }
                        }
                    case "2":
                        // Country Report for continent & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the continent name: ");
                        String continent1 = reader.readLine();
                        List<Country> topPopulatedCountriesInContinent = getTopPopulatedCountriesInContinent(limit, continent1);
                        for (Country country : topPopulatedCountriesInContinent) {
                            try {
                                System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                            }
                            catch (NullPointerException e) {
                                continue;
                            }
                        }
                    case "3":
                        // Country report for region & (limit N)
                        System.out.println("Enter the maximum number of results (0 for no limit): ");
                        limit = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the region name: ");
                        String region1 = reader.readLine();
                        List<Country> topPopulatedCountriesInRegion = getTopPopulatedCountriesInRegion(limit, region1);
                        for (Country country : topPopulatedCountriesInRegion) {
                            try {
                                System.out.println("Code: " + country.getCode() + ", Name: " + country.getName() + ", Continent: " + country.getContinent() + ", Region: " + country.getRegion() + ", Population: " + country.getPopulation() + ", Capital: " + country.getCapital().getName());
                            }
                            catch (NullPointerException e) {
                                continue;
                            }
                        }
                    case "exit":
                        break;
                    default:
                        System.out.println("Error: invalid input");
                }
            }
            catch (IOError e) {
                throw new RuntimeException(e);
                //continue;
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                continue;
            }
            catch (HibernateException e) {
                System.out.println("Database connection error");
                break;
            }
            catch (Exception e) {
                //System.out.println("Database error");
                e.printStackTrace();
                continue;
            }
        }

    }

    public static List<Country> getTopPopulatedCountries(int limit) {
        String hqlQuery = "FROM Country ORDER BY population DESC";
        return DBReader.queryCountries(hqlQuery, limit, null, null);
    }

    public static List<Country> getTopPopulatedCountriesInContinent(int limit, String continent) {
        String hqlQuery = "FROM Country WHERE continent = :continent ORDER BY population DESC";
        return DBReader.queryCountries(hqlQuery, limit, continent, "continent");
    }

    public static List<Country> getTopPopulatedCountriesInRegion(int limit, String region) {
        String hqlQuery = "FROM Country WHERE region = :region ORDER BY population DESC";
        return DBReader.queryCountries(hqlQuery, limit, region, "region");
    }

}

