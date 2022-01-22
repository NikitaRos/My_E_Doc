package com.example.myosago;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static String DB_PATH;
    public static final int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "e_docDb.db";
    public static final String TABLE_CAR = "car";
    public static final String TABLE_HEALTH = "health";
    public static final String TABLE_DOCUMENTS = "documents";

    public static final String _ID = "_id";
    public static final String NAME = "name";
    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final String NUMBER = "number";
    public static final String IMAGE = "image";

    public final Context myContext;

    public DBHelper(Context context) {
    //попыдка подключиться к готовой БД котораянаходится в папке assets
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        DB_PATH = context.getFilesDir().getPath() + DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

// попытка создать базу кодом
//        db.execSQL("create table " + TABLE_CAR + "(" +
//                _ID + " integer primary key autoincrement," +
//                NAME + " text," +
//                BRAND + " text," +
//                MODEL + " text," +
//                NUMBER + " text," +
//                IMAGE + " text" + ")");
//
//        db.execSQL("create table " + TABLE_HEALTH + "(" +
//                _ID + " integer primary key autoincrement," +
//                NAME + " text," +
//                IMAGE + " text" + ")");
//
//        db.execSQL("create table " + TABLE_DOCUMENTS + "(" +
//                _ID + " integer primary key autoincrement," +
//                NAME + " text," +
//                IMAGE + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}
