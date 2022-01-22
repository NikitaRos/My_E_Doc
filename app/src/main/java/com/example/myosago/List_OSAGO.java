package com.example.myosago;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class List_OSAGO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_osago);
    }
    public void buttonAddOSAGO(View view){
        Intent intent = new Intent(List_OSAGO.this, Add_car.class);
        startActivity(intent);
    }
}

// наброски кода для отображения в listview документов из БД
//    Cursor cursor = database.query(DBHelper.TABLE_CAR, null, null, null, null, null, null);
//
//                if (cursor.moveToFirst()) {
//                        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
//                        int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
//                        int brandIndex = cursor.getColumnIndex(DBHelper.KEY_BRAND);
//                        int modelIndex = cursor.getColumnIndex(DBHelper.KEY_MODEL);
//                        int numberIndex = cursor.getColumnIndex(DBHelper.KEY_NUMBER);
//                        int imageIndex = cursor.getColumnIndex(DBHelper.KEY_IMAGE);
//                        do {
//                        Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
//                        ", name = " + cursor.getString(nameIndex) +
//                        ", brand = " + cursor.getString(brandIndex) +
//                        ", model = " + cursor.getString(modelIndex) +
//                        ", number = " + cursor.getString(numberIndex) +
//                        ", image = " + cursor.getString(imageIndex));
//                        } while (cursor.moveToNext());
//                        } else
//                        Log.d("mLog","0 rows");
//
//                        cursor.close();