package com.example.project;

public class User {

    // Attributes

    private String username;
    private String password;
    private String email;
    private String banned;
    private String status;

    // ____________________________________________________

    public User(String username, String password, String email, String banned, String status){

        this.username = username;
        this.password = password;
        this.email = email;
        this.banned = banned;
        this.status = status;

    }

    // ____________________________________________________

    public String getEmail(){
        return this.email;
    }

    // ____________________________________________________

    public String getPassword(){
        return this.password;
    }

    // ____________________________________________________

    public String getUsername(){
        return this.username;
    }

    // ____________________________________________________

    public String getBanned(){
        return this.banned;
    }

    // ____________________________________________________

    public String getStatus(){
        return this.status;
    }

}
