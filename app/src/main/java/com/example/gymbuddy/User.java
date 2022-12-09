package com.example.gymbuddy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

public class User {
    private static User user;
    public String firstName;
    public String lastName;
    public String email;
    public String username;
    public String password;
    public ArrayList<Gym> myGyms;
    public ArrayList<Client> myClients;

    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.myGyms = new ArrayList<Gym>();
        this.myClients = new ArrayList<Client>();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static User getInstance() {
        if (user == null) {
            user = new User("admin", "admin", "admin", "admin", "admin");
        }
        return user;
    }
}
