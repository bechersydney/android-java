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
    }
}