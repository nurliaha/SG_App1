package com.nurliah.sg_app1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nurliah.sg_app1.model.USer;

import java.util.ArrayList;

public class UserRepo {
    private DBHelper dbHelper;

    public UserRepo(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public int insert(USer user){

        //Buka Databasenya buat insert data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USer.KEY_nama, user.nama);
        values.put(USer.KEY_gender, user.gender);
        values.put(USer.KEY_umur, user.umur);


        long id = db.insert(USer.TABLE, null, values);
        db.close();
        return (int) id;

    }
    public void delete(int id){
        //Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(USer.TABLE, USer.KEY_ID + "=?", new String[] { String.valueOf(id)});
        db.close();

    }
    public void update(USer user){
        //Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USer.KEY_nama, user.nama);
        values.put(USer.KEY_gender, user.gender);
        values.put(USer.KEY_umur, user.umur);

        db.update(USer.TABLE, values, USer.KEY_ID + "=?", new String[] { String.valueOf(user.id)});
        db.close();
    }
    public ArrayList<USer> getUserList(){
        //Buka database buat menulis data
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Bikin Query Select
        String selectQuery = "SELECT * FROM " + USer.TABLE;

        ArrayList<USer> userList = new ArrayList<>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        //Jika datanya ada dan cursor ngarah ke fata pertama
        if (cursor.moveToFirst()){
            //Looping selama masih ada row / data masih tersedia
            do {
                USer user = new USer();
                user.id = cursor.getInt(cursor.getColumnIndex(USer.KEY_ID));
                user.nama = cursor.getString(cursor.getColumnIndex(USer.KEY_ID));
                user.gender = cursor.getString(cursor.getColumnIndex(USer.KEY_gender));
                user.umur = cursor.getInt(cursor.getColumnIndex(USer.KEY_umur));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }
}
