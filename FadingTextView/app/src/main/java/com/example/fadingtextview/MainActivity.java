package com.example.fadingtextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fadingtextview.databinding.ActivityMainBinding;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        mBinding.btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String[] texts = {"this", "is", "another", "text"};
        mBinding.fadingtxt.setTexts(texts);
        mBinding.fadingtxt.setTimeout(300, TimeUnit.MILLISECONDS);
        mBinding.fadingtxt.forceRefresh();
    }
}