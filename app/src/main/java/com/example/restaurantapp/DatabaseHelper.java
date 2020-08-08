package com.example.restaurantapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ourRESTAURANT.db";
    private static final String CREATE_TBL_MENUS = "CREATE TABLE "
            + DatabaseContract.Users.newTABLE11 + " ("
            + DatabaseContract.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.Users.COL_foodname + " TEXT NOT NULL, "
            + DatabaseContract.Users.COL_fooddescription+ " TEXT NOT NULL, "
            + DatabaseContract.Users.COL_foodprice + " TEXT NOT NULL, "
            + DatabaseContract.Users.COL_foodimage + " TEXT NOT NULL, "
            + DatabaseContract.Users.COL_foodtype + " TEXT NOT NULL, "
     + DatabaseContract.Users.COL_pizzaprice + " TEXT NOT NULL )";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_MENUS);


        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

}