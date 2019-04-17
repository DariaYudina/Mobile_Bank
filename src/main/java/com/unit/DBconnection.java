package com.unit;
import com.unit.Entities.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        public List<Users> getUsers(){
            if (connection == null) return null;
            try {
                List<Users> users = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select  username, password, email, phone from Users");
                while (rs.next()) {
                    String usernames = rs.getString("username");
                    String passwords = rs.getString("password");
                    String emails = rs.getString("email");
                    String phones = rs.getString("phone");
                    users.add(new Users(usernames, passwords , emails, phones));
                }
                rs.close();
                statement.close();
                return users;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
}



