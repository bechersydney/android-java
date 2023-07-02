package com.example.removeactionbarfromspecificactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(view->navigate());
        // see themes and android manifest
        // in manifest set theme for activity you want to remove actionbar
        // in theme create theme that inheret parent style
    }

    private void navigate(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}