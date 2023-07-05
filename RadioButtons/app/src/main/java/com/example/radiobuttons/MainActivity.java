package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radiobuttons.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton mRadioButton;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        mBinding.one.setOnClickListener(this);
        mBinding.two.setOnClickListener(this);
        mBinding.three.setOnClickListener(this);
        mBinding.apply.setOnClickListener(v->{
            int radioId = mBinding.radioGroup.getCheckedRadioButtonId();
            mRadioButton = mBinding.getRoot().findViewById(radioId);
            mBinding.selectionText.append(mRadioButton.getText());
        });
    }
    @Override
    public void onClick(View v) {
        int radioId = mBinding.radioGroup.getCheckedRadioButtonId();
        mRadioButton = mBinding.getRoot().findViewById(radioId);
        Toast.makeText(this, mRadioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}