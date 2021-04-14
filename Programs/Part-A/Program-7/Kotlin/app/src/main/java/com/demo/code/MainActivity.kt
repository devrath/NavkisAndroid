package com.demo.code

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private var textToSpeech: TextToSpeech? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
        initilizeTextToSpeech()
    }

    private fun initilizeTextToSpeech() {
        textToSpeech = TextToSpeech(applicationContext) { i: Int ->
            if (i != TextToSpeech.ERROR) {
                // To Choose language of speech
                textToSpeech?.language = Locale.UK
            }
        }
    }

    private fun setOnClickListeners() {
        binding.apply {
            btnConvertId.setOnClickListener {
                val inputEntered = editTextTextPersonName.text.toString()
                textToSpeech?.speak(inputEntered, TextToSpeech.QUEUE_FLUSH, null)
            }
        }
    }
}