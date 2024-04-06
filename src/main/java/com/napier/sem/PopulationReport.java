package com.napier.sem;

import lombok.Getter;
import lombok.Setter;

public class PopulationReport {
    @Getter
    @Setter
    private String reportName;
    @Getter
    @Setter
    private int totalPopulation;
    @Getter
    @Setter
    private int cityPopulation;
    @Getter
    @Setter
    private int notCityPopulation;

    int getCityPercentage() {
        return cityPopulation/totalPopulation*100;
    }
    int getNotCityPercentage() {
        return notCityPopulation/totalPopulation*100;
    }

    @Override
    public String toString(){
        return "City{" +
                "name='" + reportName +
                ", total=" + totalPopulation +
                ", city=" + cityPopulation + "(" +getCityPercentage()+"%)"+
                ", notCity=" + notCityPopulation + "(" +getNotCityPercentage()+"%)"+
                '}';
    }

}
