package com.napier.sem;

import jakarta.persistence.*;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * City class for hibernate mapping
 * corresponds to city table in database
 * Include instances of capital city
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private int population;

    /**
     * Converts the city object to a string representation.
     * @return String representation of the city object.
     */
    @Override
    public String toString(){
        int num = population;
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.GERMAN);
        formatter.setGroupingUsed(true);
        String formattedNum = formatter.format(num);
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("city", name);
        jsonObject.put("country", country.getName());
        jsonObject.put("district", district);
        jsonObject.put("population", formattedNum);

        jsonArray.put(jsonObject);

        return jsonArray.toString();

    }

    /**
     * Converts the city object to a string representation if it is a capital city.
     * @return String representation of the city object if it is a capital city.
     */
    public String toStringCapital(){
        return toString();
    }
}

