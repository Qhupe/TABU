package com.example.tabu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Veritabani extends SQLiteOpenHelper {

    public  Veritabani(Context context){
        super(context,"kelimeler",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE kelimeler (id INTEGER PRIMARY KEY AUTOINCREMENT, kelime TEXT NOT NULL,yasak1 TEXT NOT NULL,yasak2 TEXT NOT NULL,yasak3 TEXT NOT NULL,yasak4 TEXT NOT NULL,yasak5 TEXT NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS kelimeler");
        onCreate(db);

    }
}
