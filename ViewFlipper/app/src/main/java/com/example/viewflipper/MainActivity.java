package com.example.viewflipper;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewflipper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);

        mBinding.next.setOnClickListener(this);
        mBinding.prev.setOnClickListener(this);

        TextView txtView = new TextView(this);
        txtView.setText("Added dynamically");
        txtView.setGravity(Gravity.CENTER);
        mBinding.viewFlipper.addView(txtView);
//        mBinding.viewFlipper.setAutoStart(true);
        mBinding.viewFlipper.setFlipInterval(2000);
        mBinding.viewFlipper.startFlipping();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mBinding.prev.getId()) {
            mBinding.viewFlipper.showPrevious();
        }
        if (v.getId() == mBinding.next.getId()) {
            mBinding.viewFlipper.showNext();
        }
    }
}