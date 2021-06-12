package com.example.fitness_1;

public class fetchdata {

    String pushups,pullups,squats,plunk, situps,distance,date;

    public fetchdata(String pushups, String pullups, String squats, String plunk, String situps, String distance,String date) {
        this.pushups = pushups;
        this.pullups = pullups;
        this.squats = squats;
        this.plunk = plunk;
        this.situps = situps;
        this.distance = distance;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPushups() {
        return pushups;
    }

    public String getPullups() {
        return pullups;
    }

    public String getSquats() {
        return squats;
    }

    public String getPlunk() {
        return plunk;
    }

    public String getSitups() {
        return situps;
    }

    public String getDistance() {
        return distance;
    }
    public fetchdata(){}
}
