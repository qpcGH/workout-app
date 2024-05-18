package com.example.outworkv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.cardview.widget.CardView

class workout_options : AppCompatActivity() {

    private lateinit var mode1: CardView
    private lateinit var mode2: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_options)

        val window: Window = window
        window.statusBarColor = resources.getColor(R.color.statusbar)
        window.navigationBarColor = resources.getColor(R.color.statusbar)

        mode1 = findViewById(R.id.exMode1)
        mode2= findViewById(R.id.exMode2)

        mode1.setOnClickListener()
        {
            val intent = Intent(this,workout::class.java)
            startActivity(intent)
        }
        mode2.setOnClickListener()
        {
            val intentt = Intent(this,ladder::class.java)
            startActivity(intentt)
        }
    }
}