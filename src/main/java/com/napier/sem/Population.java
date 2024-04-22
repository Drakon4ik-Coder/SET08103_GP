/**
 * Class to represent population data
 */
package com.napier.sem;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

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
    public String toString(){
        long num1 = totalPopulation;
        long num2 = cityPopulation;
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
        formatter.setGroupingUsed(true);
        String formattedNum1 = formatter.format(num1);
        String formattedNum2 = formatter.format(num2);

        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("country", reportName);
        jsonObject.put("total", formattedNum1);
        jsonObject.put("city", formattedNum2 + "(" + getCityPercentage() + "%)");
        String rural = "";
        if (notCityPopulation!= -1) {
            rural += notCityPopulation + "(" + getNotCityPercentage() + "%)";
        } else {
            rural += "Not Enough Data";
        }
        jsonObject.put("rural", rural);
        jsonArray.put(jsonObject);

        return jsonArray.toString();
    }
}
