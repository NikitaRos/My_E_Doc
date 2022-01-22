package com.example.myosago;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class List_documents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_documents);
    }

    public void buttonAddDocument(View view){
        Intent intent = new Intent(List_documents.this, Add_document.class);
        startActivity(intent);
    }
}
