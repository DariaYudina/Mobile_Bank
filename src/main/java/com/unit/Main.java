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
                                System.out.println("Вы выбрали таблицу Пользователи: введите username искомого поля таблицы\n");
                                Scanner in9 = new Scanner(System.in);
                                String usernames = in9.nextLine();
                                boolean res4 = DBconnection.getInstance().searchUser(usernames);
                                if(res4) System.out.println("Такое поле есть в таблице");
                                else System.out.println("Не найдено");

                                break;
                            case 2:
                                System.out.println("Вы выбрали таблицу Аккаунты: введите username искомого поля таблицы\n");
                                Scanner in10 = new Scanner(System.in);
                                String account = in10.nextLine();
                                boolean res5 = DBconnection.getInstance().searchAccount(account);
                                if(res5) System.out.println("Такое поле есть в таблице");
                                else System.out.println("Не найдено");
                                break;
                            case 3:
                                System.out.println("Вы выбрали таблицу Аккаунты: введите username искомого поля таблицы\n");
                                Scanner in11 = new Scanner(System.in);
                                String autho = in11.nextLine();
                                boolean res6 = DBconnection.getInstance().searchAuthoritie(autho);
                                if(res6) System.out.println("Такое поле есть в таблице");
                                else System.out.println("Не найдено");
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
                                System.out.println("Вы выбрали таблицу Пользователи: введите username удаяемого поля таблицы\n");
                                Scanner in8 = new Scanner(System.in);
                                String usernames = in8.nextLine();
                                int res3 = DBconnection.getInstance().deleteUser(usernames);
                                System.out.println(res3 + " Удалено");
                                break;
                            case 2:
                                System.out.println("Вы выбрали таблицу Аккаунты: введите username удаяемого поля таблицы\n");
                                Scanner in12 = new Scanner(System.in);
                                String account2 = in12.nextLine();
                                int res4 = DBconnection.getInstance().deleteAccount(account2);
                                System.out.println(res4 + " Удалено");
                                break;
                            case 3:
                                System.out.println("Вы выбрали таблицу Авторизации: введите username удаяемого поля таблицы\n");
                                Scanner in13 = new Scanner(System.in);
                                String autho2 = in13.nextLine();
                                int res5 = DBconnection.getInstance().deleteAuthoritie(autho2);
                                System.out.println(res5 + " Удалено");
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


