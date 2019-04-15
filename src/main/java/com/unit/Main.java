package com.unit;
import java.sql.*;
public class Main {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/mobilebank?serverTimezone=Europe/Samara&useSSL=false";

    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost/mobilebank?serverTimezone=Europe/Samara&useSSL=false";
            String username = "root";
            String password = "123456";
            Connection connection = null;
            String sqlCommand = "";

            try (Connection conn = DriverManager.getConnection(url, username, password)){

                System.out.println("Connection to Store DB succesfull!");
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
                while(resultSet.next()){

                    String usernames = resultSet.getString("username");
                    String emails = resultSet.getString("email");
                    String phones = resultSet.getString("phone");
                    //int price = resultSet.getInt("Price");

                    System.out.printf("Name: "+ usernames + "| email: "+ emails + "| phone: "+ phones + " "+"\n");
                }

            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }
}
