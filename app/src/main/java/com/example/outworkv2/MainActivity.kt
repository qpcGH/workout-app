package com.example.outworkv2
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {


    private lateinit var startButton: Button
    private lateinit var settingsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startExe)
        settingsButton = findViewById(R.id.goSettings)

        startButton.setOnClickListener {


                val intent = Intent(this, workout_options::class.java)
                startActivity(intent)

        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, settings::class.java)
            startActivity(intent)
        }
    }



}
