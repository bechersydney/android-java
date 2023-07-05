package com.example.textinputlayout;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{8,}" +               //at least 8 characters
                    "$");

    private TextInputLayout email, user, pass;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.login);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // use single | to make all the args are executed
        if (!validateUser() | !validateEmail() | !validatePass()) {
            return;
        }
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }

    private boolean validateEmail() {
        String emailInput = Objects.requireNonNull(email.getEditText()).getText().toString().trim();
        if (emailInput.isEmpty()) {
            email.setError("Email field is required.");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email.setError("Invalid email.");
            return false;
        } else {
            email.setError("");
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUser() {
        String userInput = Objects.requireNonNull(user.getEditText()).getText().toString().trim();
        if (userInput.isEmpty()) {
            user.setError("User field is required.");
            return false;
        } else if (userInput.length() > 15) {
            user.setError("User too long.");
            return false;
        } else {
            user.setError("");
            user.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePass() {
        String passInput = Objects.requireNonNull(pass.getEditText()).getText().toString().trim();
        if (passInput.isEmpty()) {
            pass.setError("Password field is required.");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passInput).matches()) {
            pass.setError("Password is too weak.");
            return false;
        } else {
            pass.setError("");
            pass.setErrorEnabled(false);
            return true;
        }
    }

}