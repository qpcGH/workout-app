package com.example.outworkv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Dialog
import android.content.Intent

import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.progressindicator.LinearProgressIndicator

class ladder : AppCompatActivity() {
    private val seconds: Long = 30000 // Change interval for exercise
    //30000 for 30 seconds
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var startButton: Button
    private lateinit var dialog: Dialog
    private lateinit var cancelButton: Button

    private lateinit var countdownTextView: TextView
    lateinit var countdownProgressBar:LinearProgressIndicator
    private lateinit var exerciseNamesTV: TextView
    private lateinit var imageView: ImageView
    private lateinit var pauseButton: Button
    private val handler = Handler()
    private var currentImageIndex = 0
    private var isPaused = false


    private val imageResources = listOf(
        R.drawable.rest,
        R.drawable.jjacks,
        R.drawable.mclimber,
        R.drawable.rest,
        R.drawable.jjacks,
        R.drawable.mclimber,
        R.drawable.buttkick,
        R.drawable.rest,
        R.drawable.jjacks,
        R.drawable.mclimber,
        R.drawable.buttkick,
        R.drawable.highknee,
        R.drawable.rest,
        R.drawable.jjacks,
        R.drawable.mclimber,
        R.drawable.buttkick,
        R.drawable.highknee,
        R.drawable.burpee,
        R.drawable.rest,
        R.drawable.jjacks,
        R.drawable.mclimber,
        R.drawable.buttkick,
        R.drawable.highknee,
        R.drawable.burpee,
        R.drawable.crunches,
    )
    private val exerciseNames = arrayListOf(
        "Rest",
        "Jumping Jacks",
        "Mountain Climber",
        "Rest",
        "Jumping Jacks",
        "Mountain Climber",
        "Butt Kicker",
        "Rest",
        "Jumping Jacks",
        "Mountain Climber",
        "Butt Kicker",
        "High Knee",
        "Rest",
        "Jumping Jacks",
        "Mountain Climber",
        "Butt Kicker",
        "High Knee",
        "Burpee",
        "Rest",
        "Jumping Jacks",
        "Mountain Climber",
        "Butt Kicker",
        "High Knee",
        "Burpee",
        "crunches"
    )
    private val imageUpdateInterval: Long = seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ladder)

        val window: Window = window
        window.statusBarColor = resources.getColor(R.color.statusbar)
        window.navigationBarColor = resources.getColor(R.color.statusbar)

        countdownProgressBar = findViewById(R.id.countdownProgressBar)
        startButton = findViewById(R.id.startbutton)
        countdownTextView = findViewById(R.id.countdownTextView)
        imageView = findViewById(R.id.workoutImage)
        exerciseNamesTV = findViewById(R.id.countdownTextViewEname)
        pauseButton = findViewById(R.id.pauseButton)

        countdownProgressBar.max = (seconds / 1000).toInt()

        setupCountDownTimer()
        setupDialog()

        pauseButton.setOnClickListener {
            if (isPaused) {
                resumeCountdownAndImageLoop()
            } else {
                pauseCountdownAndImageLoop()
            }
        }

        startButton.setOnClickListener {
            startWorkout()
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
            val intentBack = Intent(this, workout_options::class.java)
            startActivity(intentBack)
        }
    }

    private fun setupCountDownTimer() {
        countDownTimer = object : CountDownTimer(seconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val remainingSeconds = millisUntilFinished / 1000
                countdownTextView.text = "Time remaining: $remainingSeconds seconds"
                countdownProgressBar.progress = ((seconds - millisUntilFinished) / 1000).toInt()
            }

            override fun onFinish() {
                countdownTextView.text = "Time's up!"
                countdownProgressBar.progress = 0
                countDownTimer.start()
            }
        }
    }

    private fun setupDialog() {
        dialog = Dialog(this)
        dialog.setContentView(R.layout.ladder_complete)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.rounded))
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)
        cancelButton = dialog.findViewById(R.id.bk)
    }

    private fun pauseCountdownAndImageLoop() {
        isPaused = true
        countDownTimer.cancel()
        handler.removeCallbacks(imageUpdateRunnable)
        pauseButton.text = "Start Again"
    }

    private fun resumeCountdownAndImageLoop() {
        isPaused = false
        countDownTimer.start()
        startImageUpdateLoop()
        pauseButton.text = "Take Rest"
    }

    private fun startImageUpdateLoop() {
        handler.postDelayed(imageUpdateRunnable, imageUpdateInterval)
    }

    private val imageUpdateRunnable = object : Runnable {
        override fun run() {
            if (currentImageIndex < imageResources.size) {
                imageView.setImageResource(imageResources[currentImageIndex])
                exerciseNamesTV.text = exerciseNames[currentImageIndex].toString()
                currentImageIndex++
            } else {
                handler.removeCallbacks(this)
                dialog.show()
            }
            handler.postDelayed(this, imageUpdateInterval)
        }
    }

    private fun startWorkout() {

        startButton.visibility = View.GONE
        startImageUpdateLoop()
        countDownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(imageUpdateRunnable)
    }
}






















