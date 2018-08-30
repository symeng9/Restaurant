package com.example.meng.restaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBasefood extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "FoodMenu.db";
    public static final String TABLE_ORDER = "TABLE_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TABLENAME";

    public static final String TABLE_FOOD = "FOOD_TABLE";
    public static final String COL_3 = "FOODID";
    public static final String COL_4 = "FOODNAME";
    public static final String COL_5 = "FOODSIZE";
    public static final String COL_6 = "FOODQUALITY";




    public DataBasefood(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(" CREATE TABLE "+ TABLE_ORDER +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, TABLENAME TEXT)");
        sqLiteDatabase.execSQL(" CREATE TABLE " + TABLE_FOOD + "(FOODID INTEGER PRIMARY KEY AUTOINCREMENT, FOODNAME TEXT, FOODSIZE TEXT, FOODQUALITY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_ORDER);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_FOOD);
        onCreate(sqLiteDatabase);

    }

    public boolean InsertData(String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);

        long result = sqLiteDatabase.insert(TABLE_ORDER, null, contentValues);
        if(result==-1)
            return  false;
        else
            return true;

    }

    public boolean InsertDataFood(String name, String size, String quality){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_4, name);
        contentValues.put(COL_5, size);
        contentValues.put(COL_6, quality);

        long result = sqLiteDatabase.insert(TABLE_FOOD, null, contentValues);
        if(result==-1)
            return  false;
        else
            return true;

    }

    public boolean updateData(String id, String name){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);

        sqLiteDatabase.update(TABLE_ORDER, contentValues, "ID=?", new String[]{id});
        return true;

    }

    public boolean updateDataFood(String id, String name, String size, String quality){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_4, name);
        contentValues.put(COL_5, size);
        contentValues.put(COL_6, quality);

        sqLiteDatabase.update(TABLE_FOOD, contentValues, "ID=?", new String[]{id});
        return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor res =sqLiteDatabase.rawQuery(" select * from "+TABLE_ORDER, null);
        return  res;
    }

}
