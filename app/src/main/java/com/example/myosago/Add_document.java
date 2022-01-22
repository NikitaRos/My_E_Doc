package com.example.myosago;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import java.io.FileNotFoundException;
import java.io.InputStream;


public class Add_document extends AppCompatActivity implements View.OnClickListener{

    Button pickImage, pickPDF, addDoc;
    EditText etDoc;
    private ImageView imageView;
    private final int pick_image =1;
    private final int pick_pdf = 2;
    //DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_document);

        imageView = (ImageView) findViewById(R.id.image_search_doc);

        etDoc = (EditText) findViewById(R.id.edit_document);

        pickImage = (Button) findViewById(R.id.button_search_image);
        pickImage.setOnClickListener(this);

        pickPDF = (Button) findViewById(R.id.button_search_pdf);
        pickPDF.setOnClickListener(this)
        ;
        addDoc = (Button) findViewById(R.id.button_add_doc);
        addDoc.setOnClickListener(this);

    }
    public void onClick(View v) {
        String name = etDoc.getText().toString();
        String image = "directory";

//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();

        switch (v.getId()) {
            case R.id.button_add_doc://добавление в БД но пока без пути image
//                contentValues.put(DBHelper.NAME, name);
//                contentValues.put(DBHelper.IMAGE, image);
//
//                db.insert(DBHelper.TABLE_DOCUMENTS, null, contentValues);
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
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {

        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
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
