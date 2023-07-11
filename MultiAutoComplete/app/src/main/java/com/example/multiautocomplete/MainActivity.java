package com.example.multiautocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.multiautocomplete.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity" ;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        String[] countries = getResources().getStringArray(R.array.countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        mBinding.multi.setAdapter(adapter);
        mBinding.multi.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mBinding.show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = mBinding.multi.getText().toString();
        String[] countries = input.split("\\s*,\\s*");
        Log.i(TAG, "onClick:" + countries);
    }
}