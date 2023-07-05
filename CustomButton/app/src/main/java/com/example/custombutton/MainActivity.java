package com.example.custombutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        SwitchMaterial sw = findViewById(R.id.btn_switch);
        btn.setOnClickListener(view-> Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show());
        sw.setOnCheckedChangeListener((view, isChecked)->{
            btn.setEnabled(isChecked);
        });
        // take note, this is app also demo how to create shape, look for drawable_default.xml
        // if you want to apply it globally, set the style to theme.xml
        // if not, then set theme every button
    }
}