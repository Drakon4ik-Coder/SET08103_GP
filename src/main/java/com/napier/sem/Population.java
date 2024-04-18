package com.napier.sem;

import lombok.Getter;
import lombok.Setter;

/*
 * Helper Population class
 * store results of population reports
 */
public class Population {
    @Getter
    @Setter
    private String reportName;
    @Getter
    @Setter
    private long totalPopulation;
    @Getter
    @Setter
    private long cityPopulation;
    @Getter
    @Setter
    private long notCityPopulation;

    public Population(java.lang.String name, java.lang.Long total, java.lang.Long city, java.lang.Long notCity) {
        reportName=name;
        totalPopulation=total;
        cityPopulation=city;
        notCityPopulation=notCity;
    }

    public Population(java.lang.String name, java.lang.Long total, java.lang.Long city, java.lang.Integer notCity) {
        reportName=name;
        totalPopulation=total;
        cityPopulation=city;
        notCityPopulation=notCity;
    }

    /*
     * Population getCityPercentage method
     * returns ratio of city population to total population in percentage
     */
    int getCityPercentage() {
        if(notCityPopulation == -1) { return 100; }
        return (int)(((double)cityPopulation/totalPopulation)*100);
    }

    /*
     * Population getNotCityPercentage method
     * returns ratio of non-city population to total population in percentage
     */
    int getNotCityPercentage() {
        return (int)(((double)notCityPopulation/totalPopulation)*100);
    }

    /*
     * Population toString method
     * returns string with Population report's
     * name, total, city and non-city population
     * if there is no information about non-city population
     * it adds Not Enough Data
     */
    @Override
    public String toString(){
        String ret = "Population{" +
                "name='" + reportName + '\'' +
                ", total=" + totalPopulation +
                ", city=" + cityPopulation + "(" +getCityPercentage()+"%)"+
                ", notCity=";
        if(notCityPopulation != -1){
            ret += notCityPopulation + "(" +getNotCityPercentage()+"%)";
        }
        else {
            ret += "Not Enough Data";
        }
        ret += '}';
        return ret;
    }

}
