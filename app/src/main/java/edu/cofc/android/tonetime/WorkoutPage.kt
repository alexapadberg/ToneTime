package edu.cofc.android.tonetime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.EditText
import android.widget.TextView
import edu.cofc.android.tonetime.databinding.ActivityWorkoutPageBinding


class WorkoutPage : AppCompatActivity() {
    private lateinit var stopButton: Button
    private lateinit var finalTime : Chronometer

    private lateinit var workout1 :EditText
    private lateinit var numberOfSets1: EditText
    private lateinit var weight1 : TextView
    private lateinit var repsPerSet1 : EditText

    private lateinit var workout2 :EditText
    private lateinit var numberOfSets2: EditText
    private lateinit var weight2 : TextView
    private lateinit var repsPerSet2 : EditText .

    private lateinit var workout3: EditText
    private lateinit var numberOfSets3: EditText
    private lateinit var weight3 : TextView
    private lateinit var repsPerSet3 : EditText
    private lateinit var receiveWorkout: TextView


    private lateinit var binding: ActivityWorkoutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_page)
        binding = ActivityWorkoutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer: Chronometer = binding.timer
        stopButton = binding.stopButton
        workout1 = binding.workout1Id
        finalTime = binding.timer

        repsPerSet1 = binding.numberOfReps1Id
        numberOfSets1 = binding.numberOfSets1Id
        weight1 =binding.weight1Id

        repsPerSet2 = binding.numberOfReps2Id
        workout2 = binding.workout2Id
        numberOfSets2 = binding.numberOfSets2Id
        weight2 = binding.weight2Id

        repsPerSet3 = binding.numberOfReps3Id
        workout3 = binding.workout3Id
        numberOfSets3 = binding.numberOfSets3Id
        weight3 = binding.weight3Id


        receiveWorkout = binding.workoutNameTextView
        val receiveBackKey = intent.getStringExtra("workout_type")
        receiveWorkout.text = receiveBackKey

        binding.homeBtn.setOnClickListener {
            finish()
        }
        binding.beingWorkoutBtn.setOnClickListener {
            timer.base = SystemClock.elapsedRealtime()
            timer.start()
        }
        binding.stopButton.setOnClickListener{
            //stop the timer and proceed to the workout summary page
            timer.stop()
            val intent2 = Intent(this@WorkoutPage,
                WorkoutSummary::class.java)
            startActivity(intent2)

            //bundle to pass multiple data variables
            val extras = Bundle()
            extras.putString("workoutTime", finalTime.text.toString())

            val workout1Text = workout1.text.toString()
            extras.putString("workout1", workout1Text)
            extras.putString("numberOfSets1", numberOfSets1.text.toString())
            extras.putString("weight1", weight1.text.toString())
            extras.putString("reps1", repsPerSet1.text.toString())

            extras.putString("workout2", workout2.text.toString())
            extras.putString("numberOfSets2", numberOfSets2.text.toString())
            extras.putString("weight2",weight2.text.toString())
            extras.putString("reps2",repsPerSet2.text.toString())


            extras.putString("workout3", workout3.text.toString())
            extras.putString("numberOfSets3", numberOfSets3.text.toString())
            extras.putString("weight3",weight3.text.toString())
            extras.putString("reps3",repsPerSet3.text.toString())

            val intent3 =Intent(applicationContext, WorkoutSummary::class.java)
            intent3.putExtras(extras)
            startActivity(intent3)
        }
    }

}
