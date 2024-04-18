package com.napier.sem;

import jakarta.persistence.*;
import lombok.Data;

// Represents a country language with its ID, official status, and percentage of speakers
@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    // The composite primary key for the CountryLanguage table
    @EmbeddedId
    private CountryLanguageId id;

    // Indicates whether the language is official in the country (Yes/No)
    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial")
    private YesNo isOfficial;

    // The percentage of the population speaking the language
    @Column(name = "Percentage")
    private double percentage;
}
