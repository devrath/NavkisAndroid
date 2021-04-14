package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button startId,stopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewsForTheScreen();
        setOnClickListeners();
        chronometer.setOnChronometerTickListener(chronometerChanged -> chronometer = chronometerChanged);
    }

    private void findViewsForTheScreen() {
        chronometer = findViewById(R.id.chronometer);
        startId = findViewById(R.id.startId);
        stopId = findViewById(R.id.stopId);
    }

    private void setOnClickListeners() {
        startId.setOnClickListener(v -> {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        });
        stopId.setOnClickListener(v -> {
            chronometer.stop();
        });
    }

}