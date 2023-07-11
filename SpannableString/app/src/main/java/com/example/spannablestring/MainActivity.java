package com.example.spannablestring;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.txt);
        String text = "I want THIS and THIS to be colored";
        SpannableString ss = new SpannableString(text);
        ClickableSpan click1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.i(TAG, "onClick: One");
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE); // change text color and remove underline
                ds.setUnderlineText(false);
            }
        };
        ClickableSpan click2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Log.i(TAG, "onClick: TWO");
            }
            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED); // change text color and remove underline
                ds.setUnderlineText(false);
            }
        };
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.GREEN);
        BackgroundColorSpan yelloSpan = new BackgroundColorSpan(Color.YELLOW);
//        ss.setSpan(redSpan, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // color only inside the start and end
//        ss.setSpan(greenSpan, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // color only inside the start and end
//        ss.setSpan(yelloSpan, 27, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // color only inside the start and end
        ss.setSpan(click1, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(click2, 16, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        view.setText(ss);
        // necessary for links
        view.setMovementMethod(LinkMovementMethod.getInstance());
    }
}