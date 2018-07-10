package com.sudoajay.a9xplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sudoajay on 2/6/18.
 */

public class Sd_Card_DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "SD_Card_Path.db";
    public static  String DATABASE_TABLE_NAME = "SD_Card_Path_Table";
    public static final String col_1 = "ID";
    public static final String col_2 = "Sd_Card_Path";
    public static final String col_3 = "Sd_Card_URI";
    public Sd_Card_DataBase(Context context  )
    {
        super(context, DATABASE_NAME, null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "Sd_Card_Path TEXT ,Sd_Card_URI TEXT  )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);
        onCreate(db);
    }
    public void Fill_It(String Sd_Card_Path  ,String Sd_Card_URI ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,Sd_Card_Path);
        contentValues.put(col_3,Sd_Card_URI);
        sqLiteDatabase.insert(DATABASE_TABLE_NAME,null,contentValues);
    }
    public boolean check_For_Empty(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DATABASE_TABLE_NAME,null);
        cursor.moveToFirst();
        int count = cursor.getCount();
        if(count > 0) {
            return false;
            }
        return true;
    }
    public Cursor Get_All_Data(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+DATABASE_TABLE_NAME,null);
        return cursor;
    }
    public void Update_The_Table(String id , String Sd_Card_Path,String Sd_Card_URI ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,Sd_Card_Path);
        contentValues.put(col_3,Sd_Card_URI );
        sqLiteDatabase.update(DATABASE_TABLE_NAME,contentValues,"ID = ?",new String[] { id });
    }

}
