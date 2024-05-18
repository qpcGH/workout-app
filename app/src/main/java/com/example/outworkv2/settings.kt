package com.example.outworkv2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader

class settings : AppCompatActivity() {
    private val editTextItems = ArrayList<ExercisesRvModel>()
    private val reps = ArrayList<String>()

    ///
    private lateinit var savebutton: Button

    private lateinit var back: ImageButton

    ////
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val window: Window = window
        window.statusBarColor = resources.getColor(R.color.statusbar)
        window.navigationBarColor = resources.getColor(R.color.statusbar)

        recyclerView = findViewById(R.id.recyclerView)
        back = findViewById(R.id.back)

        recyclerView.layoutManager = LinearLayoutManager(this)

        ///
        savebutton=findViewById(R.id.ok)

        ///
        val inputStream = openFileInput("numberofReps.txt")
        val reader = BufferedReader(InputStreamReader(inputStream))
        //Reading data to show user the last numbers in reps which he saved
        var lineRead: String?
        while (reader.readLine().also { lineRead = it } != null) {
            lineRead?.let { reps.add(it) } // Add each line to the array
        }

        reader.close()
        inputStream.close()


        // Initialize editTextItems list with sample data
        editTextItems.add(ExercisesRvModel(R.drawable.pushup, reps[0], "Push Ups"))
        editTextItems.add(ExercisesRvModel(R.drawable.jjacks, reps[1], "Jumping Jacks"))
        editTextItems.add(ExercisesRvModel(R.drawable.crunches, reps[2], "Crunches"))
        editTextItems.add(ExercisesRvModel(R.drawable.barpull, reps[3], "Barbell Curl"))
        editTextItems.add(ExercisesRvModel(R.drawable.squats, reps[4], "Squats"))
        editTextItems.add(ExercisesRvModel(R.drawable.mclimber, reps[5], "Mountain Climber"))
        editTextItems.add(ExercisesRvModel(R.drawable.dmbutterfly, reps[6], "Dumbbell Fly"))
        editTextItems.add(ExercisesRvModel(R.drawable.dmbtrfky, reps[7], "Dumbbell Side Fly"))
        editTextItems.add(ExercisesRvModel(R.drawable.overhead, reps[8], "Overhead Dumbbell"))
        editTextItems.add(ExercisesRvModel(R.drawable.calf, reps[9], "Calf Raises"))

        val adapter = MyAdapter(editTextItems)
        recyclerView.adapter = adapter


        //////////////////

        ////////////////////

        savebutton.setOnClickListener()
        {

            //Wrote number of reps in storage so it can be accesed and saved easily
            val writeNumberofReps = openFileOutput("numberofReps.txt", MODE_PRIVATE)
            for (i in 0 until editTextItems.size) {
                val line = "${editTextItems[i].editTextValue.toString()}\n"
                writeNumberofReps.write(line.toByteArray())
            }

            writeNumberofReps.close()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }


        back.setOnClickListener()
        {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }





    }
}

