package com.example.fitness_1;

public class fetchdata1 {
    String distance, speed,date;

    public fetchdata1(String distance, String speed,String date) {
        this.distance = distance;
        this.speed = speed;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public String getDistance() {
        return distance;
    }

    public String getSpeed() {
        return speed;
    }
    public  fetchdata1(){}
}
