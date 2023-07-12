package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.handler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        mHandler = new Handler();

        mBinding.start.setOnClickListener(v->{
            runnable.run();
        });
        mBinding.stop.setOnClickListener(v->{
            mHandler.removeCallbacks(runnable);
        });
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "This is toast", Toast.LENGTH_SHORT).show();
            mHandler.postDelayed(this, 2000);
        }
    };

}