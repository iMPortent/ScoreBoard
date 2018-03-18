package com.example.c4q.scorboardboard.backend;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.c4q.scorboardboard.model.Objective;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by c4q on 2/28/18.
 */

public class ScoreboardDatabaseHelper extends SQLiteOpenHelper{
    public static ScoreboardDatabaseHelper scoreboardDatabaseHelper;
    private static final String DATABASE_NAME = "scoreboard.db";
    private static final String TABLE_NAME = "scoreboard";
    private static final int SCHEME_VERSION = 1;

    private ScoreboardDatabaseHelper(Context context) {
        //TAKE A LOOK AT USE OF CURSOR FACTORY FOR BETTER UNDERSTANDING OF ENVIRONMENT
        super(context, DATABASE_NAME, null , SCHEME_VERSION);
    }

    public static void initScoreboardDatabaseHelper(Context context){
        scoreboardDatabaseHelper = new ScoreboardDatabaseHelper(context);
    }

    public static ScoreboardDatabaseHelper getInstance(){
        return scoreboardDatabaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            dropTable(db);
            createTable(db);
    }

    private void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    private void createTable(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(id_ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "objective TEXT, playerOne TEXT, playerTwo TEXT)"
        );
    }

    private void addRow(SQLiteDatabase db){

        ContentValues rowValues = new ContentValues();
        db.insert(TABLE_NAME, null , rowValues );
    }

    public static String jsonifyPlayer(Objective objective){
        Gson gson = new Gson();
        return gson.toJson(objective);
    }

    public static Objective toObjective(String objectiveString){
         Gson gson = new Gson();
         return gson.fromJson(objectiveString, Objective.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
