package com.example.c4q.scorboardboard.model;

/**
 * Created by c4q on 3/7/18.
 */

public class Objective {
    private Player playerOne, playerTwo;
    private String objective;
    private int limit;


    public Objective(String objective, String playerOneName, String playerTwoName, int limit){
        this.objective = objective;
        this.limit = limit;
        this.playerOne = new Player(playerOneName);
        this.playerTwo = new Player(playerTwoName);
    }

    public int getLimit(){
        return limit;
    }

    public String getObjective(){
        return objective;
    }
    public Player getPlayerOne(){
        return playerOne;
    }

    public Player getPlayerTwo(){
        return playerTwo;
    }


}
