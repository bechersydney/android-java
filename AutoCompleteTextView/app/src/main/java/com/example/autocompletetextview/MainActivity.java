package com.example.autocompletetextview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autocompletetextview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String[] COUNTRIES = {"Philippines", "Korea", "Japan", "Singapore", "Taiwan"};
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
//          for custom layout
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.auto_complete, R.id.txt, countries);
        mBinding.auto.setAdapter(adapter);
    }
}