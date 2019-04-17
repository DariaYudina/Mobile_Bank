package com.unit;
import java.sql.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        DBconnection.getInstance();
        boolean menu = true;
        Scanner in = new Scanner(System.in);
        while(menu){
            System.out.println("1. Показать всё \n2. Добавить запись \n3. Найти запись \n4. Удалить запись \n5. Выйти ");
            int choice = -1;
            while (true)
            {
                System.out.println("Выберите пункт меню:");
                String line = in.nextLine();
                try
                {
                    choice = Integer.parseInt(line);
                        break;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Вы ввели не число");
                }
            }
            switch (choice){
                case 1: System.out.println("вы  выбрали 1");

                    break;
                case 2: System.out.println("вы  выбрали 2"); break;
                case 3: System.out.println("вы  выбрали 3"); break;
                case 4: System.out.println("вы  выбрали 5"); break;
                case 5: System.out.println("Выбрано выйти"); menu = false; break;
                default:
                    System.out.println("Выберите существующий пункт меню");
                    break;
            }
       }
        DBconnection.closeConnection();
    }
}


       /*
       try{
           ResultSet resultSet = DataBase.getInstance().query("SELECT * FROM Users");
           while(resultSet.next()){

               String usernames = resultSet.getString("username");
               String emails = resultSet.getString("email");
               String phones = resultSet.getString("phone");
               //int price = resultSet.getInt("Price");

               System.out.printf("Name: %s; email: %s; phone: %s\n",usernames, emails, phones);
           }
       }
       catch (Exception ex){
           System.out.println("query failed...");
           System.out.println(ex);
       }
      */