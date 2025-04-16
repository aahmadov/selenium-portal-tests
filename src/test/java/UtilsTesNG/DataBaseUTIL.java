package UtilsTesNG;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseUTIL {

    private static Connection connection;
    private static Connection connection2;
    private static Connection connection3;
    private static Connection connection84;
    private static Connection connection46;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void openConnection() throws SQLException {
        if (connection != null && connection.isValid(20)) {
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Ooops error!");
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(ConfigReader.getProperty("mysql.url_IgnoreBusyFeature"),
                ConfigReader.getProperty("replixdb.username"),
                ConfigReader.getProperty("replixdb.password"));

        connection2 = DriverManager.getConnection(ConfigReader.getProperty("mysql.url_IgnoreBusyFeature"),
                ConfigReader.getProperty("replixdb.username"),
                ConfigReader.getProperty("replixdb.password"));


        connection3 = DriverManager.getConnection(ConfigReader.getProperty("mysql.url_IgnoreBusyFeatureNEw"),
                ConfigReader.getProperty("replixdb.username"),
                ConfigReader.getProperty("replixdb.password"));

        connection84 = DriverManager.getConnection(ConfigReader.getProperty("mysql.url_IgnoreBusyFeatureNEw84"),
                ConfigReader.getProperty("replixdb.username"),
                ConfigReader.getProperty("replixdb.password"));

        connection46 = DriverManager.getConnection(ConfigReader.getProperty("mysql.url_46"),
                ConfigReader.getProperty("replixdb.username"),
                ConfigReader.getProperty("replixdb.password"));
    }

    public static List<Map<String, Object>> executeSQLQuery(String query) throws SQLException {

        openConnection();
        statement = connection84.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                System.out.print(metaData.getColumnName(column) + ":");
                map.put(metaData.getColumnName(column), resultSet.getObject(column));
                System.out.println(map.put(metaData.getColumnName(column), resultSet.getObject(column)));
            }

            System.out.print("\n");

            table.add(map);
        }
        closeConnection();
        return table;
    }
    public static List<Map<String, Object>> executeSQLQueryRecvD(String query) throws SQLException {

        openConnection();
        statement = connection84.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                System.out.print(metaData.getColumnName(column) + ":");
                map.put(metaData.getColumnName(column), resultSet.getObject(column));
                System.out.println(map.put(metaData.getColumnName(column), resultSet.getObject(column)));
            }

            System.out.print("\n");

            table.add(map);
        }
        closeConnection();
        return table;
    }

    public static List<Map<String, Object>> executeSQLQuery84Database(String query) throws SQLException {

        openConnection();
        statement = connection84.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                System.out.print(metaData.getColumnName(column) + ":");
                map.put(metaData.getColumnName(column), resultSet.getObject(column));
                System.out.println(map.put(metaData.getColumnName(column), resultSet.getObject(column)));
            }

            System.out.print("\n");

            table.add(map);
        }
        closeConnection();
        return table;
    }
    public static List<Map<String, Object>> executeSQLQuery46Database(String query) throws SQLException {

        openConnection();
        statement = connection46.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                System.out.print(metaData.getColumnName(column) + ":");
                map.put(metaData.getColumnName(column), resultSet.getObject(column));
                System.out.println(map.put(metaData.getColumnName(column), resultSet.getObject(column)));
            }

            System.out.print("\n");

            table.add(map);
        }
        closeConnection();
        return table;
    }


    public static List<Map<String, Object>> executeSQLQueryOCRNew1(String query) throws SQLException {
        openConnection();
        statement = connection84.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();

        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                String columnName = metaData.getColumnName(column);
                Object columnValue = resultSet.getObject(column);
                map.put(columnName, columnValue);

                // Print column name and value
                System.out.println(columnName + ": " + columnValue);
            }

            table.add(map);
        }

        // Close the database connection
        closeConnection();

        // Extract and print the "metadata" object
        if (!table.isEmpty()) {
            Map<String, Object> firstRow = table.get(0);
            if (firstRow.containsKey("metadata")) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode metadataNode = objectMapper.readTree((String) firstRow.get("metadata"));

                    // Print the "metadata" object
                    System.out.println("metadata:");
                    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metadataNode));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return table;
    }
    public static List<Map<String, Object>> executeSQLQuery46(String query) throws SQLException {
        openConnection();
        statement = connection46.createStatement();
        resultSet = statement.executeQuery(query);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<Map<String, Object>> table = new ArrayList<>();

        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int column = 1; column <= columnCount; column++) {
                String columnName = metaData.getColumnName(column);
                Object columnValue = resultSet.getObject(column);
                map.put(columnName, columnValue);

                // Print column name and value
                System.out.println(columnName + ": " + columnValue);
            }

            table.add(map);
        }

        // Close the database connection
        closeConnection();

        // Extract and print the "metadata" object
        if (!table.isEmpty()) {
            Map<String, Object> firstRow = table.get(0);
            if (firstRow.containsKey("metadata")) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode metadataNode = objectMapper.readTree((String) firstRow.get("metadata"));

                    // Print the "metadata" object
                    System.out.println("metadata:");
                    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(metadataNode));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return table;
    }

    public static void executeSQLUpdate(final String query) throws SQLException {
        openConnection();
        statement = connection.createStatement();
        int noOfLines = statement.executeUpdate(query);
        closeConnection();
    }

    public static void executeSQLUpdate2(final String query) throws SQLException {
        openConnection();
        statement = connection2.createStatement();
        int noOfLines = statement.executeUpdate(query);
        closeConnection();
    }
    public static void executeSQLUpdateRecvD(final String query) throws SQLException {
        openConnection();
        statement = connection3.createStatement();
        int noOfLines = statement.executeUpdate(query);
        closeConnection();
    }

    public static void executeSQLUpdateRecvD81(final String query) throws SQLException {
        openConnection();
        statement = connection84.createStatement();
        int noOfLines = statement.executeUpdate(query);
        closeConnection();
    }
    public static void executeSQLUpdateRecvD46(final String query) throws SQLException {
        openConnection();
        statement = connection46.createStatement();
        int noOfLines = statement.executeUpdate(query);
        closeConnection();
    }


    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


