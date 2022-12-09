package com.example.gymbuddy;

import java.util.Calendar;

public class Appointment {
    public Gym gym;
    public Client client;
    public Calendar date;
    public String activity;

    public Appointment(Gym gym, Client client, Calendar date, String activity) {
        this.gym = gym;
        this.client = client;
        this.date = date;
        this.activity = activity;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
