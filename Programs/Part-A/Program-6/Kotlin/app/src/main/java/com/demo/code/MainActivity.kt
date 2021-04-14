package com.demo.code

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.demo.code.databinding.ActivityMainBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setonClickListener()
    }

    private fun setonClickListener() {
        binding.apply {
            jsonBtnId.setOnClickListener { parseJson() }
            xmlBtnId.setOnClickListener { }
        }
    }

    private fun parseJson() {
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val cityNome = obj["cityNome"].toString()
            val latitude = obj["latitude"].toString()
            val longitude = obj["longitude"].toString()
            val temperature = obj["temperature"].toString()
            val humidity = obj["humidity"].toString()
            binding.apply {
                cityNameId.text = cityNome
                latitudeValueId.text = latitude
                longitudeValueId.text = longitude
                temperatureValueId.text = temperature
                humidityValueId.text = humidity
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String? {
        var json = ""
        try {
            val `is` = assets.open("jsonsample.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}