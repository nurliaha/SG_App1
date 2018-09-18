package com.nurliah.sg_app1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nurliah.sg_app1.model.USer;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sg_android.db";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null  , DATABASE_VERSION);
    }

    @Override
//    create table di database STUDENT
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE " + USer.TABLE + "("
                + USer.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + USer.KEY_nama + " TEXT, "
                + USer.KEY_umur + " INTEGER ,"
                + USer.KEY_gender + " TEXT)";

        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
