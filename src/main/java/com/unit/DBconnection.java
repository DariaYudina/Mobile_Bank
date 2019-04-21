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
        public List<User> getUsers(){
            if (connection == null) return null;
            try {
                List<User> users = new ArrayList<>();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select  username, password, email, phone from Users");
                while (rs.next()) {
                    String usernames = rs.getString("username");
                    String passwords = rs.getString("password");
                    String emails = rs.getString("email");
                    String phones = rs.getString("phone");
                    users.add(new User(usernames, passwords , emails, phones));
                }
                rs.close();
                statement.close();
                return users;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    public List<Account> getAccount(){
        if (connection == null) return null;
        try {
            List<Account> accounts = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select  username, code, accountNumber, amount from Accounts");
            while (rs.next()) {
                String usernames = rs.getString("username");
                String code = rs.getString("code");
                Integer accountNumber = rs.getInt("accountNumber");
                Double amount = rs.getDouble("amount");
                accounts.add(new Account(usernames, code , accountNumber, amount));
            }
            rs.close();
            statement.close();
            return accounts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Authoritie> getAuthorities(){
        if (connection == null) return null;
        try {
            List<Authoritie> authorities = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select  username, authority from autho");
            while (rs.next()) {
                String usernames = rs.getString("username");
                String authority = rs.getString("authority");
                authorities.add(new Authoritie(usernames, authority));
            }
            rs.close();
            statement.close();
            return authorities;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int setUser(User u){
        if (connection == null) return 0;
        try{
            String sql = "INSERT Users(username, password, email, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, u.getEmail());
            preparedStatement.setString(4, u.getPhone());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rows;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int setAccount(Account u){
        if (connection == null) return 0;
        try{
            String sql = "INSERT Accounts(username, code, accountNumber, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getCode());
            preparedStatement.setInt(3, u.getAccountNumber());
            preparedStatement.setDouble(4, u.getAmount());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rows;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int setAuthoritie(Authoritie u){
        if (connection == null) return 0;
        try{
            String sql = "INSERT Autho(username, authority) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getAuthority());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rows;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public int deleteUser(String username){
        if (connection == null) return 0;
        try{
            String sql = "DELETE FROM Users WHERE UserName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            return rows;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    public boolean searchUser(String username){
        if (connection == null) return false;
        boolean isUserExists = false;
        try{
            String sql = "SELECT 1 FROM Users WHERE UserName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    isUserExists = true;
                    return isUserExists ;}
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}

// int rows = statement.executeUpdate("DELETE FROM Products WHERE Id = 3");
