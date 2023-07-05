package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.progressbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        updateProgressBar();
        mBinding.dec.setOnClickListener(v->{
            if(progress <= 90){
                progress += 10;
                updateProgressBar();
            }
        });

        mBinding.inc.setOnClickListener(v->{
            if(progress >= 10){
                progress -= 10;
                updateProgressBar();
            }
        });
    }

    private void updateProgressBar(){
        mBinding.percent.setText("" + progress+ "%");
        mBinding.progressBar.setProgress(progress);

    }
}