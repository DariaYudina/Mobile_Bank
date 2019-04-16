package com.unit;
import java.sql.*;
public class Main {

    public static void main(String[] args) {
       DataBase.getInstance();
       try{
           ResultSet resultSet = DataBase.getInstance().query("SELECT * FROM Users");
           while(resultSet.next()){

               String usernames = resultSet.getString("username");
               String emails = resultSet.getString("email");
               String phones = resultSet.getString("phone");
               //int price = resultSet.getInt("Price");
               System.out.printf("Name: "+ usernames + "| email: "+ emails + "| phone: "+ phones + " "+"\n");
           }
       }
       catch (Exception ex){
           System.out.println("query failed...");
           System.out.println(ex);
       }

        boolean menu=true;
        while(menu){
            System.out.println("menu...");
            menu = false;
       }
    }
}


