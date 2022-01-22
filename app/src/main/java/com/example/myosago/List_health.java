package com.example.myosago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class List_health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_health);
    }

    public void buttonAddHealthDoc(View view){
        Intent intent = new Intent(List_health.this, Add_health.class);
        startActivity(intent);
    }
}
