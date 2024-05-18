package com.example.outworkv2

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class workout : AppCompatActivity() {

    private lateinit var buttonNext: Button
    private lateinit var buttonBack: Button
    private lateinit var setCount: TextView
    private lateinit var repCount: TextView
    private lateinit var imageView: ImageView
    var setCounter: Int = 1
    var repCounter: Int = 0
    var exercisecounter: Int = 0
    private lateinit var dialog: Dialog;
    private lateinit var addset: Button
    private lateinit var cancel: Button


    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        val window: Window = window
        window.statusBarColor = resources.getColor(R.color.statusbar)
        window.navigationBarColor = resources.getColor(R.color.statusbar)


        var repCountArray = ArrayList<String>()

        val inputStream = openFileInput("numberofReps.txt")
        val reader = BufferedReader(InputStreamReader(inputStream))
        var lineRead: String?
        while (reader.readLine().also { lineRead = it } != null) {
            lineRead?.let { repCountArray.add(it) }
        }

        reader.close()
        inputStream.close()



        buttonNext = findViewById(R.id.next)
        buttonBack = findViewById(R.id.back)
        imageView = findViewById(R.id.workoutImageview)
        setCount = findViewById(R.id.setCount)
        repCount = findViewById(R.id.repCount)

        setCount.text = "Set #${setCounter}".toString()
        repCount.text = "Do ${repCountArray[0]} reps".toString()


        //Create the Dialog here
        dialog = Dialog(this);
        dialog.setContentView(R.layout.setcomplete);
        dialog.getWindow()?.setBackgroundDrawable(getDrawable(R.drawable.rounded));
        dialog.getWindow()
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        //dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        addset = dialog.findViewById(R.id.addset);
        cancel = dialog.findViewById(R.id.bk);

        buttonNext.setOnClickListener()
        {
            exercisecounter++
            when (exercisecounter) {
                0 -> {
                    imageView.setImageResource(R.drawable.pushup)
                    repCount.text ="Do ${repCountArray[0]} reps" // Assuming the list is 0-based
                }
                1 -> {
                    imageView.setImageResource(R.drawable.jjacks)
                    repCount.text = "Do ${repCountArray[1]} reps" // Assuming the list is 0-based
                }

                2 -> {
                    imageView.setImageResource(R.drawable.crunches)
                    repCount.text ="Do ${repCountArray[2]} reps"
                }

                3 -> {
                    imageView.setImageResource(R.drawable.barpull)
                    repCount.text ="Do ${repCountArray[3]} reps"
                }

                4 -> {
                    imageView.setImageResource(R.drawable.squats)
                    repCount.text ="Do ${repCountArray[4]} reps"
                }

                5 -> {
                    imageView.setImageResource(R.drawable.mclimber)
                    repCount.text = "Do ${repCountArray[5]} reps"
                }

                6 -> {
                    imageView.setImageResource(R.drawable.dmbutterfly)
                    repCount.text = "Do ${repCountArray[6]} reps"
                }

                7 -> {
                    imageView.setImageResource(R.drawable.dmbtrfky)
                    repCount.text = "Do ${repCountArray[7]} reps"
                }


                8 -> {
                    imageView.setImageResource(R.drawable.overhead)
                    repCount.text ="Do ${repCountArray[8]} reps"
                }

                9 -> {
                    imageView.setImageResource(R.drawable.calf)
                    repCount.text ="Do ${repCountArray[9]} reps"
                }



                else -> {
                    // Handle other cases or provide a default image
                    // For example:
                    if (exercisecounter > 5) {
                        dialog.show()
                    }
                    addset.setOnClickListener()
                    {
                        setCounter++
                        dialog.dismiss();
                        exercisecounter = 0
                        setCount.text = "Set #${setCounter}"
                        imageView.setImageResource(R.drawable.pushup)
                        repCount.text="Do ${repCountArray[0]} reps"

                    }
                   //
                }
            }
            buttonBack.setOnClickListener()
            {
                if (exercisecounter > 0) {
                    exercisecounter--
                }
                when (exercisecounter) {
                    0 -> {
                        imageView.setImageResource(R.drawable.pushup)
                        repCount.text ="Do ${repCountArray[0]} reps" // Assuming the list is 0-based
                    }
                    1 -> {
                        imageView.setImageResource(R.drawable.jjacks)
                        repCount.text = "Do ${repCountArray[1]} reps" // Assuming the list is 0-based
                    }

                    2 -> {
                        imageView.setImageResource(R.drawable.crunches)
                        repCount.text ="Do ${repCountArray[2]} reps"
                    }

                    3 -> {
                        imageView.setImageResource(R.drawable.barpull)
                        repCount.text ="Do ${repCountArray[3]} reps"
                    }

                    4 -> {
                        imageView.setImageResource(R.drawable.squats)
                        repCount.text ="Do ${repCountArray[4]} reps"
                    }

                    5 -> {
                        imageView.setImageResource(R.drawable.mclimber)
                        repCount.text = "Do ${repCountArray[5]} reps"
                    }

                    6 -> {
                        imageView.setImageResource(R.drawable.dmbutterfly)
                        repCount.text = "Do ${repCountArray[6]} reps"
                    }

                    7 -> {
                        imageView.setImageResource(R.drawable.dmbtrfky)
                        repCount.text = "Do ${repCountArray[7]} reps"
                    }


                    8 -> {
                        imageView.setImageResource(R.drawable.overhead)
                        repCount.text ="Do ${repCountArray[8]} reps"
                    }

                    9 -> {
                        imageView.setImageResource(R.drawable.calf)
                        repCount.text ="Do ${repCountArray[9]} reps"
                    }
                    else -> {
                        // Handle other cases or provide a default image
                        // For example:
                        imageView.setImageResource(R.drawable.pushup)
                        repCount.text="Do ${repCountArray[0]} reps"
                        exercisecounter = 0;
                    }
                }

            }
            cancel.setOnClickListener()
            {
                dialog.dismiss();
                exercisecounter = 0;
                val flagBack = true
                buttonNext.isClickable = false
                buttonNext.setBackgroundColor(resources.getColor(R.color.md_theme_light_onSurfaceVariant))
                if (flagBack) {
                    buttonBack.setOnClickListener()
                    {
                        val intentBack = Intent(this, workout_options::class.java)
                        startActivity(intentBack)
                    }

                }


            }


        }
    }




}