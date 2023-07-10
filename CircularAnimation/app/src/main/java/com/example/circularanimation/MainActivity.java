package com.example.circularanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.circularanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mBinding.getRoot();
        setContentView(view);
        mBinding.hide.setOnClickListener(this);
        mBinding.show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mBinding.show.getId()) {
            int cx = mBinding.fab.getWidth() / 2;
            int cy = mBinding.fab.getHeight() / 2;

            float finalRadius = (float) Math.hypot(cx, cy);
            Animator animator = ViewAnimationUtils.createCircularReveal(mBinding.fab, cx, cy, 0, finalRadius);
            mBinding.fab.setVisibility(View.VISIBLE);
            animator.start();
        }
        if (v.getId() == mBinding.hide.getId()) {
            int cx = mBinding.fab.getWidth() / 2;
            int cy = mBinding.fab.getHeight() / 2;

            float initialRadius = (float) Math.hypot(cx, cy);
            Animator animator = ViewAnimationUtils.createCircularReveal(mBinding.fab, cx, cy, initialRadius, 0);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mBinding.fab.setVisibility(View.INVISIBLE);
                }
            });
            animator.start();
        }
    }
}