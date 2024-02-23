package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/world";
    private static String username = "root";
    private static String password = "1234";

    private static Connection connection = null;

    public static List<List<String>> QueryDB(String sqlQuery) {
        List<List<String>> results = new ArrayList<List<String>>();
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                List<String> result = new ArrayList<>();
                // Process the result set
                for (int i = 1; i <= columnCount; i++) {
                    result.add(resultSet.getString(i));
                }
                results.add(result);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
