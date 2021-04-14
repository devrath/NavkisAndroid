package com.demo.code

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var chronometer: Chronometer? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        findViewsForTheScreen()
        setOnClickListeners()
        binding.chronometer.onChronometerTickListener = OnChronometerTickListener { chronometerChanged: Chronometer? -> chronometer = chronometerChanged }
    }

    private fun findViewsForTheScreen() {
        chronometer = findViewById(R.id.chronometer)
    }

    private fun setOnClickListeners() {
        binding.startId.setOnClickListener {
            chronometer?.base = SystemClock.elapsedRealtime()
            chronometer?.start()
        }
        binding.stopId.setOnClickListener { chronometer?.stop() }
    }
}