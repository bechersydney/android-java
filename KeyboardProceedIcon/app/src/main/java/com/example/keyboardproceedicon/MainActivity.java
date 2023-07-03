package com.example.keyboardproceedicon;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imeoptions in xml file will change the keyboard icon
        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);

        user.setOnEditorActionListener(listener);
        pass.setOnEditorActionListener(listener);
    }

    private final TextView.OnEditorActionListener listener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            switch (i) {
                case EditorInfo.IME_ACTION_SEND:
                    Toast.makeText(MainActivity.this, "Sending", Toast.LENGTH_SHORT).show();
                    break;
                case EditorInfo.IME_ACTION_DONE:
                    Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };
}