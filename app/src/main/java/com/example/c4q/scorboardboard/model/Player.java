package com.example.c4q.scorboardboard.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by c4q on 3/15/18.
 */

public class Player {
    private String name;
    private ArrayList<Point>points;


    public Player(String name){
        this.name = name;
        points = new ArrayList<>();
    }

    public void addPoint(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String currDate = dateFormat.format(new Date());
        points.add(new Point(currDate));
    }

    public void addPoint(String description){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
        String currDate = dateFormat.format(new Date());
        points.add(new Point(currDate, description));
    }

    public void subtractPoint(){
        if(points.size()>0) {
            points.remove(points.size() - 1);
        }
    }

    public String getName(){
        return name;
    }

    public int getTotalPoints(){
        return points.size();
    }

    public ArrayList<Point> getPointsList(){
        return points;
    }
}
