package com.napier.sem;

import org.hibernate.HibernateException;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*List<Country> countries = DBReader.queryCountries("FROM Country", 10);
        for (Country country : countries) {
            System.out.println(country.toString());
        }

        List<City> cities = DBReader.queryCities("FROM City", 10);
        for (City city : cities) {
            System.out.println(city.toString());
        }*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter:\n1 - Display the countries in the world by population\n2 - Display the countries in a continent organised by population\n3 - Display the countries in a region organised by population\nexit - Quit the program");
            try {
                String input = reader.readLine();
                int limit = 0;
                switch (input) {
                    case "1":
                        // Country Report for world
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





}

