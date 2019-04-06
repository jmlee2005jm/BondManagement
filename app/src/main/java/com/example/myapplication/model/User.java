package com.example.myapplication.model;

public class User {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUserModel(String email, String password, String name) {
        User user = new User();

        user.email = email;
        user.password = password;
        user.name = name;

        return user;
    }

    @Override
    public String toString() {
        return String.format("email[%s], password[%s], name[%s]", email, password, name);
    }
}
