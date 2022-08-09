package com.example.loginform.model;

public class User {
    private String username;
    private String name;
    private String password;
    private String address;
    private String birthdate;

    public User() {
    }

    public User(String username, String pass) {
        this.username = username;
        this.password = pass;
    }

    public User(String username, String pass, String name, String address, String birthday) {
        this.username = username;
        this.password = pass;
        this.name = name;
        this.address = address;
        this.birthdate = birthday;
    }

    public User(String username, String name, String address, String birthday) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.birthdate = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthdate;
    }

    public void setBirthday(String birthday) {
        this.birthdate = birthday;
    }

}
