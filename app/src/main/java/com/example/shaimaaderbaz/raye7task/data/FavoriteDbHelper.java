package com.example.shaimaaderbaz.raye7task.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Shaimaa Derbaz on 2/6/2018.
 */

public class FavoriteDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FavoriteContract.FavoriteEntry.TABLE_NAME + " (" +
                    FavoriteContract.FavoriteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FavoriteContract.FavoriteEntry.COLUMN_FAVORITE_TITLE + " TEXT NOT NULL," +
                    FavoriteContract.FavoriteEntry.COLUMN_TIME + " TEXT NOT NULL," +
                    FavoriteContract.FavoriteEntry.COLUMN_URL + " TEXT NOT NULL," +
                    FavoriteContract.FavoriteEntry.COLUMN_IMAGE_UrL + " TEXT);";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FavoriteContract.FavoriteEntry.TABLE_NAME;
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "FavoritesInv.db";

    public FavoriteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}