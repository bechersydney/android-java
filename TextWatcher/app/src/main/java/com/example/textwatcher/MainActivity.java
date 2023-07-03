package com.example.textwatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText pass,user;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.login);
        user.addTextChangedListener(textWatcher);
        pass.addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String userName = user.getText().toString().trim();
            String password = pass.getText().toString().trim();
            btn.setEnabled(!userName.isEmpty() && !password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}