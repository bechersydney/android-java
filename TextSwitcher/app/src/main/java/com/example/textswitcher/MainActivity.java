package com.example.textswitcher;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.textswitcher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBinding;
    private int idx = 0;
    private String[] row = {"Ot", "THREE", "FOUR", "FIVE"};
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        mBinding.btn.setOnClickListener(this);
        mBinding.text.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                mTextView = new TextView(MainActivity.this);
                mTextView.setTextColor(Color.BLACK);
                mTextView.setTextSize(60);
                mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                return mTextView;

            }
        });

        mBinding.text.setText(row[idx]);
    }

    @Override
    public void onClick(View v) {
        if (idx == row.length - 1) {
            idx = 0;
            mBinding.text.setText(row[idx]);
        } else {
            Log.e(TAG, "onClick: " + idx);
            mBinding.text.setText(row[++idx]);
        }


    }
}