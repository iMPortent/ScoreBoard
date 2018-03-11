package com.example.c4q.scorboardboard;

/**
 * Created by c4q on 3/7/18.
 */

public class Objective {
    private String playerOne, playerTwo, objective;
    private int playerOneScore = 0, playerTwoScore = 0, limit;

    public void addPointOne(){
        playerOneScore++;
    }

    public void addPointTwo(){
        playerTwoScore++;
    }

    public Objective setPlayerOne(String playerOne){
        this.playerOne = playerOne;
        return this;
    }

    public Objective setPlayerTwo(String playerTwo){
        this.playerTwo = playerTwo;
        return this;
    }

    public Objective setObjective(String objective){
        this.objective = objective;
        return this;
    }

    public Objective setLimit (int limit){
        this.limit = limit;
        return this;
    }

    public String getPlayerOne(){
        return playerOne;
    }

    public String getPlayerTwo(){
        return playerTwo;
    }

    public int getPlayerOneScore() {
     return playerOneScore;
    }

    public int getPlayerTwoScore(){
        return playerTwoScore;
    }

    public String getObjective(){
        return objective;
    }

    public int getLimit(){
        return limit;
    }
}
