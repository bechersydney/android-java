package com.example.toolbarbackbutton;

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
        btn.setOnClickListener(view -> navigate());
        getSupportActionBar().setTitle("Main");

        // to make the backbutton work please check the manifest file for the parenting of activity
    }

    private void navigate() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
