package com.example.myosago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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


}