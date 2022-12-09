package com.example.gymbuddy;

import java.util.ArrayList;

public class Gym {
    public String title, description;
    public int icon;
    public ArrayList<Client> myClients;

    public Gym(String title, int icon) {
        this.title = title;
        this.icon = icon;
        this.description = description;
        this.myClients = new ArrayList<Client>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(int icon) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
