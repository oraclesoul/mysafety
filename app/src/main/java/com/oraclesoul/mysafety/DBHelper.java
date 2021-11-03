package com.oraclesoul.mysafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MySafety";
    public static final String DB_TABLE_NAME = "EmergencyContacts";
    public static final int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + DB_TABLE_NAME + "(username TEXT PRIMARY KEY , contact TEXT NOT NULL)";
        Log.i("mytag", sql);
        sqLiteDatabase.execSQL(sql);

    }

    public boolean isDetailsSet()
    {
        String sql = "SELECT * FROM " + DB_TABLE_NAME;
        Cursor c = this.getWritableDatabase().rawQuery(sql,null);
        if(c.getCount()>0) return true;
        return false;
    }

    public  Detail getDetails()
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "SELECT * FROM " + DB_TABLE_NAME;
        Cursor c = this.getWritableDatabase().rawQuery(sql,null);

        String name="NOthing";
        String phone="7056228038";
        if(c.moveToFirst())
        {
            name = c.getString(0);
            phone = c.getString(1);
        }

        Detail detail = new Detail(name,phone);

        return detail;

    }

    public boolean insertData(String name,String number)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",name);
        contentValues.put("contact",number);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        long res = sqLiteDatabase.insert(DB_TABLE_NAME,null,contentValues);

        if(res == -1) return false;
        return true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
