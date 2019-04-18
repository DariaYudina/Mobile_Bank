package com.unit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.unit.Entities.*;

public class Main {

    public static void main(String[] args) {
        DBconnection.getInstance();

        boolean menu = true;
        Scanner in = new Scanner(System.in);
        while(menu){
            System.out.println("1. Показать всё \n2. Добавить запись \n3. Найти запись \n4. Удалить запись \n5. Выйти ");
            int choice = -1;
            //валидация---
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
            //-----
            switch (choice){
                case 1:
                    boolean menu2 = true;
                    Scanner in2 = new Scanner(System.in);
                    while(menu2){
                        int choice2 = -1;
                        //валидация---
                        while (true)
                        {
                            System.out.println("В базе данных мобильного банка 3 таблицы, выберите какую показать:");
                            System.out.println("1. Users \n2. Account \n3. Authorities \n4. Выйти ");
                            System.out.println("Выберите пункт меню:");
                            String line2 = in2.nextLine();
                            try
                            {
                                choice2 = Integer.parseInt(line2);
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Вы ввели не число");
                            }
                        }
                        //-----
                        switch (choice2){
                            case 1:
                                List<Users> users = DBconnection.getInstance().getUsers();
                                System.out.println("Таблица Пользователи:\n");
                                for (Users item : users) {
                                    System.out.println(item);
                                    System.out.println();
                                }
                                break;
                            case 2:
                                List<Account> accounts = DBconnection.getInstance().getAccount();
                                System.out.println("Таблица Аккаунты:\n");
                                for (Account item : accounts) {
                                    System.out.println(item);
                                    System.out.println();
                                }
                                break;
                            case 3:
                                List<Authoritie> authorities = DBconnection.getInstance().getAuthorities();
                                System.out.println("Таблица Авторизации:\n");
                                for (Authoritie item : authorities) {
                                    System.out.println(item);
                                    System.out.println();
                                }
                                break;
                            case 4: System.out.println("Вы выбрали выйти"); menu2 = false; break;
                            default:
                                System.out.println("Выберите существующий пункт меню");
                                break;
                        }
                    }
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
               String passwords = resultSet.getString("password");
               String emails = resultSet.getString("email");
               String phones = resultSet.getString("phone");
               System.out.printf("name: %s; password: %s; email: %s; phone: %s\n",usernames, passwords, emails, phones);
           }
       }
       catch (Exception ex){
           System.out.println("query failed...");
           System.out.println(ex);
       }
      */