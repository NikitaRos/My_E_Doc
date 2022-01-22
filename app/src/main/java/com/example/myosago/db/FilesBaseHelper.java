package com.example.myosago.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.myosago.db.FilesDbSchema.DocumentsTable;

public class FilesBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "documentsBase.db";

    public  FilesBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("create table %s " +
                        "( _id integer primary key autoincrement, %s, %s )",
                DocumentsTable.NAME,
                DocumentsTable.Cols.DESCRIPTION,
                DocumentsTable.Cols.PATH));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
