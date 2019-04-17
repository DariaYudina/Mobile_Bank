package com.unit.Entities;
import java.util.ArrayList;
import java.util.List;
public class Users {
    private String username ;
    private String password ;
    private String email ;
    private String phone ;
    private List<Users> users = new ArrayList<>();

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

    public List<Users> getUsers() {
        return users;
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

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    public void addUsers(Users u){
        users.add(u);
    }
    @Override
    public String toString() {
        return "Пользователи{" +
                "username=" + username +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}


