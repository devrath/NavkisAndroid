package com.demo.code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button jsonBtnId, xmlBtnId;
    private TextView cityNameId,latitudeValueId,longitudeValueId,temperatureValueId,humidityValueId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        setonClickListener();
    }

    private void setonClickListener() {
        jsonBtnId.setOnClickListener(v -> {
            parseJson();
        });
        xmlBtnId.setOnClickListener(v -> {

        });
    }

    private void findViewById() {
        jsonBtnId = findViewById(R.id.jsonBtnId);
        xmlBtnId = findViewById(R.id.xmlBtnId);
        cityNameId = findViewById(R.id.cityNameId);
        latitudeValueId = findViewById(R.id.latitudeValueId);
        longitudeValueId = findViewById(R.id.longitudeValueId);
        temperatureValueId = findViewById(R.id.temperatureValueId);
        humidityValueId = findViewById(R.id.humidityValueId);
    }

    private void parseJson() {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            String cityNome = obj.get("cityNome").toString();
            String latitude = obj.get("latitude").toString();
            String longitude = obj.get("longitude").toString();
            String temperature = obj.get("temperature").toString();
            String humidity = obj.get("humidity").toString();

            cityNameId.setText(cityNome);
            latitudeValueId.setText(latitude);
            longitudeValueId.setText(longitude);
            temperatureValueId.setText(temperature);
            humidityValueId.setText(humidity);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("jsonsample.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}