package com.example.changefont;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create folder in res named 'font'
        // add all the downloaded font
        // then create font resource file
        // TODO: to apply the font app wide
        // please see the theme.xml file
        TextView tt = findViewById(R.id.textView);
        // apply dynamic font family
        // applicable in higher api
        //Typeface typeface = getResources().getFont(this, R.font.bold);
        // change typeface dynamically
//         Typeface t = Typeface.create(tt, 200, false);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.bold);
        tt.setOnClickListener(view->tt.setTypeface(typeface));

    }
}