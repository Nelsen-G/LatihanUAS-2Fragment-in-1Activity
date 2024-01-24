package com.example.latihanuas7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE user_data (" +
                "name TEXT, " +
                "age INTEGER);";
        sqLiteDatabase.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upgrade = "DROP TABLE IF EXISTS user_data";
        sqLiteDatabase.execSQL(upgrade);
        onCreate(sqLiteDatabase);
    }

    public long insertData(String name, int age){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);

        return db.insert("user_data", null, cv);

    }

    public ArrayList<Dosen> getALlDosen(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Dosen> listDosen = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM user_data", null);

        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            int age = cursor.getInt(1);

            listDosen.add(new Dosen(name, age));
        }

        cursor.close();

        return listDosen;

    }
}
