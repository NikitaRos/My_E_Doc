package com.example.myosago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.example.myosago.db.FilesBaseHelper;
import com.example.myosago.db.FilesDbSchema;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = new FilesBaseHelper(this.getApplicationContext())
                .getWritableDatabase();

        AddDoc("Passport", "\\docs\\passport.pdf");
        AddDoc("Passport", "\\docs\\foreign.jpg");
        AddDoc("qr_covid", "\\medical\\qr.jpg");

        LinkedList<String> res = GetDocPath("Passport");
        Log.i("read_sql", res.toString());

        res = GetDocPath("qr_covid");
        Log.i("read_sql", res.toString());

    }

    public void buttonAuto(View view){
        Intent intent = new Intent(MainActivity.this, List_OSAGO.class);
        startActivity(intent);
    }

    public  void buttonHealth(View view){
        Intent intent = new Intent(MainActivity.this, List_health.class);
        startActivity(intent);
    }

    public  void buttonDocument(View view){
        Intent intent = new Intent(MainActivity.this, List_documents.class);
        startActivity(intent);
    }

    // Insert Doc (with duplicates).
    public  boolean AddDoc(String description, String path){
        ContentValues val = new ContentValues();
        val.put(FilesDbSchema.DocumentsTable.Cols.DESCRIPTION, description);
        val.put(FilesDbSchema.DocumentsTable.Cols.PATH, path);

        return mDatabase.insert(FilesDbSchema.DocumentsTable.NAME, null, val) != -1;
    }

    // Delete Doc by description if exist.
    public boolean DeleteDoc(String description){
        return mDatabase.delete(FilesDbSchema.DocumentsTable.NAME,
                FilesDbSchema.DocumentsTable.Cols.DESCRIPTION+"=\""+description+"\"",
                null) != -1;
    }

    // Get list of 'path' from sql or empty list.
    public LinkedList<String> GetDocPath(String description){
        LinkedList<String> res = new LinkedList<String>();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(FilesDbSchema.DocumentsTable.Cols.PATH);
        sb.append(" FROM ");
        sb.append(FilesDbSchema.DocumentsTable.NAME);
        sb.append(" WHERE ");

        sb.append(FilesDbSchema.DocumentsTable.Cols.DESCRIPTION);
        sb.append("=\"");
        sb.append(description);
        sb.append("\"");

        Cursor cursor = mDatabase.rawQuery(
                sb.toString(),
                null);

        try{
            if (cursor.getCount() == 0) {
                return res;
            }

            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                int id = cursor.getColumnIndex(FilesDbSchema.DocumentsTable.Cols.PATH);
                res.add(cursor.getString(id));
                cursor.moveToNext();
            }

        }finally {
            cursor.close();
        }

        return res;
    }
}