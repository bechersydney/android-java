package com.example.openplaystoreandratemedialog;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // open google play
//        try {
//            startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("market://details?id=" + getPackageName())));
//        } catch (ActivityNotFoundException e) {
//            startActivity(new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
//        }
        // show rating pop up
        
    }
}