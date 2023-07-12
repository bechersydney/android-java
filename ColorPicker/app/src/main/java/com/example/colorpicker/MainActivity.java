package com.example.colorpicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout mMainLayout;
    int mDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainLayout = findViewById(R.id.main);
        mDefaultColor = ContextCompat.getColor(this, R.color.red);
//        mMainLayout.setBackgroundColor(mDefaultColor);
        Button btn = findViewById(R.id.show);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AmbilWarnaDialog dialog = new AmbilWarnaDialog(MainActivity.this, mDefaultColor, true, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mDefaultColor = color;
                mMainLayout.setBackgroundColor(mDefaultColor);
            }
        });
        dialog.show();
    }
}