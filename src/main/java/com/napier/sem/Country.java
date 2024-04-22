package com.napier.sem;

import jakarta.persistence.*;
import lombok.Data;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This class represents a Country with various attributes such as code, name, continent, region, population, and capital.
 */
@Data
@Entity
@Table(name = "country")
public class Country {

    /**
     * The unique code of the country.
     */
    @Id
    @Column(name = "Code")
    private String code;

    /**
     * The name of the country.
     */
    @Column(name = "Name")
    private String name;

    /**
     * The continent where the country is located.
     * This attribute is converted using the ContinentEnumConverter class.
     */
    @Column(name = "Continent")
    @Convert(converter = ContinentEnumConverter.class)
    private Continent continent;

    /**
     * The region where the country is located.
     */
    @Column(name = "Region")
    private String region;

    /**
     * The population of the country.
     */
    @Column(name = "Population")
    private int population;

    /**
     * The capital city of the country.
     * This attribute is a ManyToOne relationship with the City class.
     */
    @ManyToOne
    @JoinColumn(name = "Capital")
    private City capital;

    /**
     * Overrides the toString() method to provide a custom string representation of the Country object.
     * @return A string representation of the Country object.
     */
    @Override
    public String toString(){
        int num = population;
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
        formatter.setGroupingUsed(true);
        String formattedNum = formatter.format(num);

        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("country", name);
        jsonObject.put("code", code);
        jsonObject.put("continent", continent);
        jsonObject.put("region", region);
        jsonObject.put("population", formattedNum);
        jsonObject.put("capital", (capital != null ? capital.getName() : "null"));

        jsonArray.put(jsonObject);

        return jsonArray.toString();
    }
}



