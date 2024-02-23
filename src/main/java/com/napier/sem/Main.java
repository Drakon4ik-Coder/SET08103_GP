package com.napier.sem;

import java.util.List;

import static com.napier.sem.DBReader.QueryDB;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        List<List<String>> results1 = QueryDB("SELECT * FROM country LIMIT 10;");
        for (List<String> result: results1) {
            System.out.println(result.toString());
        }
        List<List<String>> results2 = QueryDB("SELECT * FROM city LIMIT 10;");
        for (List<String> result: results2) {
            System.out.println(result.toString());
        }

    }
}