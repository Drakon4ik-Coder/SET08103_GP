package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class AppTest {
    static Main app;

    @BeforeAll
    static void init() {
        app = new Main();
    }

    @Test
    void country_report_for_world_test_negative_limit() {
        DBReader.queryCountries(Query.Country.getWorldDesc(), -1);
    }

    @Test
    void test() {
        Assertions.assertEquals(5, 5);
    }
}
