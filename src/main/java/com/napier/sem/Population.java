/**
 * Class to represent population data
 */
package com.napier.sem;

import lombok.Getter;
import lombok.Setter;

/**
 * Population class containing population data for a given area
 */
public class Population {

    /**
     * The name of the report
     */
    @Getter
    @Setter
    private String reportName;

    /**
     * The total population of the area
     */
    @Getter
    @Setter
    private long totalPopulation;

    /**
     * The population of the city in the area
     */
    @Getter
    @Setter
    private long cityPopulation;

    /**
     * The population of the area outside of the city
     */
    @Getter
    @Setter
    private long notCityPopulation;

    /**
     * Constructor for Population class
     *
     * @param name   The name of the report
     * @param total  The total population of the area
     * @param city   The population of the city in the area
     * @param notCity The population of the area outside of the city
     */
    public Population(String name, Long total, Long city, Long notCity) {
        reportName = name;
        totalPopulation = total;
        cityPopulation = city;
        notCityPopulation = notCity;
    }

    /**
     * Overloaded constructor for Population class
     *
     * @param name   The name of the report
     * @param total  The total population of the area
     * @param city   The population of the city in the area
     * @param notCity The population of the area outside of the city
     */
    public Population(String name, Long total, Long city, Integer notCity) {
        reportName = name;
        totalPopulation = total;
        cityPopulation = city;
        notCityPopulation = notCity;
    }

    /**
     * Method to calculate the percentage of city population
     *
     * @return The percentage of city population
     */
    int getCityPercentage() {
        if (notCityPopulation == -1) {
            return 100;
        }
        return (int) (((double) cityPopulation / totalPopulation) * 100);
    }

    /**
     * Method to calculate the percentage of non-city population
     *
     * @return The percentage of non-city population
     */
    int getNotCityPercentage() {
        return (int) (((double) notCityPopulation / totalPopulation) * 100);
    }

    /**
     * Override toString method to display population data in a formatted string
     *
     * @return The population data in a formatted string
     */
    @Override
    public String toString() {
        String ret = "Population{" +
                "name='" + reportName + '\'' +
                ", total=" + totalPopulation +
                ", city=" + cityPopulation + "(" + getCityPercentage() + "%)" +
                ", notCity=";
        if (notCityPopulation!= -1) {
            ret += notCityPopulation + "(" + getNotCityPercentage() + "%)";
        } else {
            ret += "Not Enough Data";
        }
        ret += '}';
        return ret;
    }

}
