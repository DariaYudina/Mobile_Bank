package com.unit.Entities;

public class Authoritie {
    private String username ;
    private String authority;

    public Authoritie(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }

    @Override
    public String toString() {
        return "{" +
                "username = " + username +
                ", authority = '" + authority + '\''+ "}";
    }
}
