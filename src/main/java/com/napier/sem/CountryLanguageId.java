package com.napier.sem;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class CountryLanguageId implements Serializable {
    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "Language")
    private String language;
}
