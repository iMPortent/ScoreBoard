package com.example.c4q.scorboardboard.model;

/**
 * Created by c4q on 3/15/18.
 */

public class Point {
    String date, description;

    public Point(){

    }

    public Point(String date){
        this.date = date;
    }

    public Point(String date, String description){
        this.date = date;
        this.description = description;
    }

    public String getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

}
