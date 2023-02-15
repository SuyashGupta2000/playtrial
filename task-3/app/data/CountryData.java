package data;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CountryData {
    private Connection connection;

    public CountryData() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/country_details", "root", "password");
    }

    public Map<Integer, String> getCountryMap() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from country");
        Map<Integer, String> country = new HashMap<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            country.put(id, name);
        }
        return country;
    }
}

//public class RestClient {
//    private Connection connection;
//    private Map<Integer, String> map;
//    public RestClient() throws SQLException {
//        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/country_details", "root", "password");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from country");
//        Map<Integer, String> country = new HashMap<>();
//        while (resultSet.next()){
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            country.put(id, name);
//        }
//        System.out.println(country);
//        this.map=country;
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public Map<Integer, String> getMap() {
//        return map;
//    }
//}
