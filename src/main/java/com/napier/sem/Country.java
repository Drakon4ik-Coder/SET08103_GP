package com.napier.sem;
import jakarta.persistence.*;
import lombok.Data;


/*
 * Country class for hibernate mapping
 * corresponds to country table in database
 */
@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    //@Enumerated(EnumType.STRING)
    @Column(name = "Continent")
    @Convert(converter = ContinentEnumConverter.class)
    private Continent continent;

    @Column(name = "Region")
    private String region;

    @Column(name = "Population")
    private int population;

    @ManyToOne
    @JoinColumn(name = "Capital")
    private City capital;

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital=" + (capital != null ? capital.getName() : "null") + // Display capital information
                '}';
    }
}



