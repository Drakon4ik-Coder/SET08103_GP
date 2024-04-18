package com.napier.sem;

import jakarta.persistence.*;
import lombok.Data;

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

    /*
     * City toString method
     * returns string with City's
     * name, country, district and population
     */
    @Override
    public String toString(){
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country.getName() + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
    /*
     * City toStringCapital method
     * called when City need to be treated as CapitalCity
     * call toString method if not capitalCity
     * Otherwise
     * returns string with City's
     * name, country and population
     */
    public String toStringCapital(){
        if (country.getCapital()==this) {
            return "CapitalCity{" +
                    "name='" + getName() + '\'' +
                    ", country='" + getCountry().getName() + '\'' +
                    ", population=" + getPopulation() +
                    '}';
        }
        return toString();
    }
}

