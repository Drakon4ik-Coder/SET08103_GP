package com.napier.sem;
import jakarta.persistence.*;
import lombok.Data;


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

    @Column(name = "SurfaceArea")
    private double surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(name = "Population")
    private int population;

    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpOld;

    @Column(name = "LocalName")
    private String localName;

    @Column(name = "GovernmentForm")
    private String governmentForm;

    @Column(name = "HeadOfState")
    private String headOfState;

    @ManyToOne
    @JoinColumn(name = "Capital")
    private City capital;

    @Column(name = "Code2")
    private String code2;

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent=" + continent +
                ", region='" + region + '\'' +
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", population=" + population +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gnp=" + gnp +
                ", gnpOld=" + gnpOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", capital=" + (capital != null ? capital.getName() : "null") + // Display capital information
                ", code2='" + code2 + '\'' +
                '}';
    }
}



