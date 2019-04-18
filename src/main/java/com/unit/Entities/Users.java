package com.unit.Entities;
import java.util.ArrayList;
import java.util.List;
public class Users {
    private String username ;
    private String password ;
    private String email ;
    private String phone ;

    public Users(String username, String password , String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
                "username = " + username +
                ", password = '" + password + '\'' +
                ", email = '" + email + '\'' +
                ", phone = '" + phone + '\'' +
                '}';
    }

}


