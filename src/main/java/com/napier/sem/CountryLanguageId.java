package com.napier.sem;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

/*
 * CountryLanguageId class
 * used for mapping Country class to CountryLanguage class
 */
@Data
@Embeddable
public class CountryLanguageId implements Serializable {
    // The country code for the CountryLanguage object
    @Column(name = "CountryCode")
    private String countryCode;

    // The language for the CountryLanguage object
    @Column(name = "Language")
    private String language;
}
