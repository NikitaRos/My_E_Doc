package com.example.myosago;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class Add_car extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etBrand, etModel, etNumber;
    Button pickImage, pickPDF, addDoc;
    private ImageView imageView;
    private final int pick_image = 1;
    private final int pick_pdf = 2;
    //DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        imageView = (ImageView) findViewById(R.id.image_search_doc);

        etName = (EditText) findViewById(R.id.edit_doc_name);
        etBrand = (EditText) findViewById(R.id.edit_car_brand);
        etModel = (EditText) findViewById(R.id.edit_car_model);
        etNumber = (EditText) findViewById(R.id.edit_car_number);

        addDoc = (Button) findViewById(R.id.button_add_car);
        addDoc.setOnClickListener(this);

        pickImage = (Button) findViewById(R.id.button_search_image);
        pickImage.setOnClickListener(this);

        pickPDF = (Button) findViewById(R.id.button_search_pdf);
        pickPDF.setOnClickListener(this);

        //dbHelper = new DBHelper(this);

    }
    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String brand = etBrand.getText().toString();
        String model = etModel.getText().toString();
        String number = etNumber.getText().toString();
        String image = "directory";
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.button_add_car://добавление в БД но пока без пути image
//                contentValues.put(DBHelper.NAME, name);
//                contentValues.put(DBHelper.BRAND, brand);
//                contentValues.put(DBHelper.MODEL, model);
//                contentValues.put(DBHelper.NUMBER, number);
//                contentValues.put(DBHelper.IMAGE, image);
//
//                db.insert(DBHelper.TABLE_CAR, null, contentValues);
                //dbHelper.close();
                finish();
                break;
            case R.id.button_search_image:
                Intent photoIntent = new Intent(Intent.ACTION_PICK);
                photoIntent.setType("image/*");
                startActivityForResult(photoIntent, pick_image);
                break;
            case R.id.button_search_pdf:
                Intent pdfIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                pdfIntent.putExtra("CONTENT_TYPE","*/*");
                startActivityForResult(pdfIntent, pick_pdf);
                break;
        }
        //dbHelper.close();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {

        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            case pick_pdf:
                if (resultCode == RESULT_OK) {

                    //здесь конвертация pdf

                }
        }
    }
}
