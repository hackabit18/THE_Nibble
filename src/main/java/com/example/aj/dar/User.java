package com.example.aj.dar;

/**
 * Created by AJ on 10/27/2018.
 */

public class User {

    public String id;
    public String name;
    public String email;
    public String password;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {

    }

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserId(){
        return id;
    }
    public String getUserName(){
        return name;
    }
    public String getUserEmail(){
        return email;
    }
    public String getUserPassword(){
        return password;
    }
}