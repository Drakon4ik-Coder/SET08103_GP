package com.napier.sem;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial")
    private YesNo isOfficial;

    @Column(name = "Percentage")
    private double percentage;
}
