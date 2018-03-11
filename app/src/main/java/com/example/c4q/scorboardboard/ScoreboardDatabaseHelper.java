package com.example.c4q.scorboardboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by c4q on 2/28/18.
 */

public class ScoreboardDatabaseHelper extends SQLiteOpenHelper {

    private  Context context;
    private static final String DATABASE_NAME = "scoreboard.db";
    private static final String TABLE_NAME = "scoreboard";
    private static final int SCHEME_VERSION = 1;

    public ScoreboardDatabaseHelper(Context context) {
        //TAKE A LOOK AT USE OF CURSOR FACTORY FOR BETTER UNDERSTANDING OF ENVIRONMENT
        super(context, DATABASE_NAME, null , SCHEME_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(id_ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "objective TEXT, playerOne INTEGER, playerTwo INTEGER)"
        );

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
