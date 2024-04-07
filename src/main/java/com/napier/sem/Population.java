package com.napier.sem;

import lombok.Getter;
import lombok.Setter;

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

    long getCityPercentage() {
        return cityPopulation/totalPopulation*100;
    }
    long getNotCityPercentage() {
        return notCityPopulation/totalPopulation*100;
    }

    @Override
    public String toString(){
        return "population{" +
                "name='" + reportName +
                ", total=" + totalPopulation +
                ", city=" + cityPopulation + "(" +getCityPercentage()+"%)"+
                ", notCity=" + notCityPopulation + "(" +getNotCityPercentage()+"%)"+
                '}';
    }

}
