package com.example.longteng.androidui.ProgressBar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.longteng.androidui.R;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBarHor;
    NumberProgressBar numberProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        progressBarHor = (ProgressBar) findViewById(R.id.progressBarHor);
        numberProgressBar = (NumberProgressBar) findViewById(R.id.numberProgressBar);
        progressBarHor.setProgress(30);

        numberProgressBar.setProgress(39);
    }
}
