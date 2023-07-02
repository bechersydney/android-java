package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // switch will not work here since resource ids are not really constansts
        if (item.getItemId() == R.id.item1) {

            Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.item2) {

            Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.item3) {

            Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.sub1) {

            Toast.makeText(this, "Sub item 1", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (item.getItemId() == R.id.sub2) {

            Toast.makeText(this, "Sub item 2", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}