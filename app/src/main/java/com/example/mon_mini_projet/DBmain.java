package com.example.mon_mini_projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBmain extends SQLiteOpenHelper {
    public static final String DB="sushis";
    public static final int VER=1;
    public DBmain(@Nullable Context context) {
        super(context, DB, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table sushi(id integer primary key,sub text,sub2 text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop="drop table if exists sushi";
        db.execSQL(drop);
        onCreate(db);

    }
}
