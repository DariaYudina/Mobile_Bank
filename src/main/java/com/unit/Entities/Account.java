package com.unit.Entities;
public class Account {

    private String username ;
    private String code ;
    private int accountNumber;
    private double amount ;

    public Account(String username, String code, int accountNumber, double amount) {
        this.username = username;
        this.code = code;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public String getCode() {
        return code;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{" +
                "username = " + username +
                ", code = '" + code + '\'' +
                ", accountNumber = '" + accountNumber + '\'' +
                ", amount = '" + amount + '\'' +
                '}';
    }
}
