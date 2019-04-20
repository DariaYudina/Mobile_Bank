package com.unit;
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
                            System.out.println("1. User \n2. Account \n3. Authorities \n4. Выйти ");
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
                                List<User> users = DBconnection.getInstance().getUsers();
                                System.out.println("Таблица Пользователи:\n");
                                for (User item : users) {
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
                case 2:
                        boolean menu3 = true;
                        Scanner in3 = new Scanner(System.in);
                        while(menu3){
                        int choice2 = -1;
                            //валидация---
                            while (true)
                            {
                                System.out.println("В базе данных мобильного банка 3 таблицы, выберите в какую добавить запись:");
                                System.out.println("1. User \n2. Account \n3. Authorities \n4. Выйти ");
                                System.out.println("Выберите пункт меню:");
                                String line2 = in3.nextLine();
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
                                    Scanner in6 = new Scanner(System.in);
                                    String usernames = in6.nextLine();
                                    String passwords = in6.nextLine();
                                    String emails = in6.nextLine();
                                    String phones = in6.nextLine();
                                    User u = new User(usernames, passwords, emails, phones);
                                    int i = DBconnection.getInstance().setUser(u);
                                    System.out.println("Пользователей добавлено: "+ i);
                                    break;
                                case 2:
                                    Scanner in7 = new Scanner(System.in);
                                    String usernames1 = in7.nextLine();
                                    String code = in7.nextLine();
                                    Integer accountNumber = in7.nextInt();
                                    Double amount = in7.nextDouble();
                                    Account a = new Account(usernames1, code, accountNumber, amount);
                                    int i2 = DBconnection.getInstance().setAccount(a);
                                    System.out.println("Аккаунтов добавлено:"+ i2);
                                    break;
                                case 3:
                                    Scanner in8 = new Scanner(System.in);
                                    String usernames2 = in8.nextLine();
                                    String autirity = in8.nextLine();
                                    Authoritie au = new Authoritie(usernames2,autirity);
                                    int i3 = DBconnection.getInstance().setAuthoritie(au);
                                    System.out.println("Авторизаций добавлено: "+ i3);
                                    break;
                                case 4: System.out.println("Вы выбрали выйти"); menu3 = false; break;
                                default:
                                    System.out.println("Выберите существующий пункт меню");
                                    break;
                            }
                        }
                    break;
                case 3:
                    boolean menu4 = true;
                    Scanner in4 = new Scanner(System.in);
                    while(menu4){
                        int choice2 = -1;
                        //валидация---
                        while (true)
                        {
                            System.out.println("В базе данных мобильного банка 3 таблицы, выберите в какой найти запись:");
                            System.out.println("1. User \n2. Account \n3. Authorities \n4. Выйти ");
                            System.out.println("Выберите пункт меню:");
                            String line2 = in4.nextLine();
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

                                System.out.println("Таблица Пользователи:\n");

                                break;
                            case 2:
                                System.out.println("Таблица Аккаунты:\n");

                                break;
                            case 3:
                                System.out.println("Таблица Авторизации:\n");
                                break;
                            case 4: System.out.println("Вы выбрали выйти"); menu4 = false; break;
                            default:
                                System.out.println("Выберите существующий пункт меню");
                                break;
                        }
                    }
                break;
                case 4:
                    boolean menu5 = true;
                    Scanner in5 = new Scanner(System.in);
                    while(menu5){
                        int choice2 = -1;
                        //валидация---
                        while (true)
                        {
                            System.out.println("В базе данных мобильного банка 3 таблицы, выберите в какой удалить запись:");
                            System.out.println("1. User \n2. Account \n3. Authorities \n4. Выйти ");
                            System.out.println("Выберите пункт меню:");
                            String line2 = in5.nextLine();
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

                                System.out.println("Таблица Пользователи:\n");

                                break;
                            case 2:
                                System.out.println("Таблица Аккаунты:\n");

                                break;
                            case 3:
                                System.out.println("Таблица Авторизации:\n");
                                break;
                            case 4: System.out.println("Вы выбрали выйти"); menu5 = false; break;
                            default:
                                System.out.println("Выберите существующий пункт меню");
                                break;
                        }
                    }
                    break;
                case 5: System.out.println("Вы выбрали выйти"); menu = false; break;
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
           ResultSet resultSet = DataBase.getInstance().query("SELECT * FROM User");
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