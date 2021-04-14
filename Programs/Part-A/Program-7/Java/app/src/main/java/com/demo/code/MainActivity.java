package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTextPersonName;
    private Button btnConvertId;

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setOnClickListeners();
        initilizeTextToSpeech();
    }

    private void initilizeTextToSpeech() {
        textToSpeech = new TextToSpeech(getApplicationContext(), i -> {
            if(i!=TextToSpeech.ERROR){
                // To Choose language of speech
                textToSpeech.setLanguage(Locale.UK);
            }
        });
    }

    private void findViews() {
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        btnConvertId = findViewById(R.id.btnConvertId);
    }

    private void setOnClickListeners() {
        btnConvertId.setOnClickListener(v -> {

            String inputEntered = editTextTextPersonName.getText().toString();

            textToSpeech.speak(inputEntered,TextToSpeech.QUEUE_FLUSH,null);
        });
    }

}