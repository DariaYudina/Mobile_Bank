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
            System.out.println("1. Показать всё \n2. Добавить запись \n3. Найти запись \n4. Удалить запись \n5. Выйти \n");
            int choice = 3;
            switch (choice){
                case 3: menu = false;System.out.println("Выбрано выйти"); break;
            }

       }
    }
}


