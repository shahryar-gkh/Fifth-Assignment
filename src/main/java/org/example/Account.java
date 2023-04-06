package org.example;

public class Account {
    public Account() {
    }
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected String username;
    protected String password;

    //Setters

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //Getters

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
