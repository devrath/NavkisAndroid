package com.demo.code

import android.app.WallpaperManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.button).setOnClickListener { setWallpaper() }
    }

    private fun setWallpaper() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.wallpaper)
        val manager = WallpaperManager.getInstance(applicationContext)
        try {
            manager.setBitmap(bitmap)
            Toast.makeText(this, "Wallpaper added", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
        }
    }
}