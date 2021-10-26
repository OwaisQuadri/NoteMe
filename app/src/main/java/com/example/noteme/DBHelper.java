package com.example.noteme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) { super(context, "Notes.db", null, 2); }

    @Override
    public void onCreate(SQLiteDatabase DB) { DB.execSQL("create Table Notes(title TEXT primary key, subtitle TEXT, body TEXT, colour TEXT)"); }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) { DB.execSQL("drop Table if exists Notes.db"); }

    public Boolean insertNote(String title, String subtitle, String body, String colour)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("subtitle", subtitle);
        contentValues.put("body", body);
        contentValues.put("colour", colour);
        long result = DB.insert("Notes", null, contentValues);
        return result != -1;
    }

    public Cursor getNotes()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Notes", null);
        return cursor;
    }
}