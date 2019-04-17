package com.unit;

import java.sql.*;

public class DBconnection {
        private  String url = "jdbc:mysql://localhost/mobilebank?serverTimezone=Europe/Samara&useSSL=false";
        private  String username = "root";
        private  String password = "123456";
        private  static Connection connection = null;
        private  String sqlCommand = "";
        private Statement statement;
        private static DBconnection  Base;
        private DBconnection (){
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to Store DB succesfull!");
                Statement statement = connection.createStatement();

            }
            catch(Exception ex){
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        };
        public static DBconnection  getInstance() {
            if (Base == null) {
                Base = new DBconnection ();
            }
            return Base;
        }
        public static void closeConnection() {
            if (connection == null) {
                System.out.println("No connection");
            }
            else {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("Close connection");
                }
                catch (SQLException e) {
                    System.out.println("Failed to close the connection");
                }
            }
        }

        public int insert(String insertQuery) throws SQLException {
            statement = Base.connection.createStatement();
            int result = statement.executeUpdate(insertQuery);
            return result;

        }

        public ResultSet query(String query) throws SQLException{
            statement = Base.connection.createStatement();
            ResultSet res = statement.executeQuery(query);
            return res;
        }
}



