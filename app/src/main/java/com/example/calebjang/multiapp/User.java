package com.example.calebjang.multiapp;

//User class which holds the model of the user
//containing all of the users variables and gets/sets them
public class User {
    public String id;
    public String userName;
    public String email;
    public String password;

    public User(String id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}