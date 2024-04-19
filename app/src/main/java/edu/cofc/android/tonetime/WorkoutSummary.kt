package edu.cofc.android.tonetime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer
import android.widget.TextView

import edu.cofc.android.tonetime.databinding.ActivityWorkoutSummaryBinding
import kotlin.math.round
import kotlin.math.roundToInt

class WorkoutSummary : AppCompatActivity() {
    private var poundAmount1: Double = 0.0
    private var poundAmount2: Double = 0.0
    private var poundAmount3: Double = 0.0

    private lateinit var binding: ActivityWorkoutSummaryBinding
    private lateinit var receivedTime : Chronometer

    private lateinit var receiveWork1 : TextView
    private lateinit var receiveSet1 : TextView
    private lateinit var receivedWeight1 : TextView
    private lateinit var receiveReps1 : TextView

    private lateinit var receiveWork2 : TextView
    private lateinit var receiveSet2 : TextView
    private lateinit var receivedWeight2 : TextView
    private lateinit var receiveReps2 : TextView

    private lateinit var receiveWork3 : TextView
    private lateinit var receiveSet3 : TextView
    private lateinit var receivedWeight3 : TextView
    private lateinit var receiveReps3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_summary)
        binding = ActivityWorkoutSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiveWork1 = binding.workoutResult1Id
        receiveSet1 = binding.receivedNumberOfSets1Id
        receivedWeight1 = binding.receivedWeight1Id
        receiveReps1 = binding.receivedRepsPerSet1

        receiveWork2 = binding.workoutResult2Id
        receiveSet2 = binding.receivedNumberOfSets2Id
        receivedWeight2 = binding.receivedWeight2Id
        receiveReps2 = binding.receivedRepsPerSet2

        receiveWork3 = binding.workoutResult3Id
        receiveSet3 = binding.receivedNumberOfSets3Id
        receivedWeight3 = binding.receivedWeight3Id
        receiveReps3 = binding.receivedRepsPerSet3

        receivedTime = binding.timeReceived

        val intent = intent
        val bundle = intent.extras
        if (bundle != null) {
            receivedTime.text = intent.getStringExtra("workoutTime")

            receiveWork1.text = intent.getStringExtra("workout1")
            receiveSet1.text= intent.getStringExtra("numberOfSets1")
            receivedWeight1.text = intent.getStringExtra("weight1")
            receiveReps1.text = intent.getStringExtra("reps1")

            receiveWork2.text = intent.getStringExtra("workout2")
            receiveSet2.text= intent.getStringExtra("numberOfSets2")
            receivedWeight2.text = intent.getStringExtra("weight2")
            receiveReps2.text = intent.getStringExtra("reps2")

            receiveWork3.text = intent.getStringExtra("workout3")
            receiveSet3.text= intent.getStringExtra("numberOfSets3")
            receivedWeight3.text = intent.getStringExtra("weight3")
            receiveReps3.text = intent.getStringExtra("reps3")


            poundAmount1 = receivedWeight1.text.toString().toDouble() / 2.2
            binding.weight1InKgs.text = poundAmount1.roundToInt().toString()

            poundAmount2 = receivedWeight2.text.toString().toDouble() / 2.2
            binding.weight2InKgs.text = poundAmount2.roundToInt().toString()

            poundAmount3 = receivedWeight3.text.toString().toDouble() / 2.2
            binding.weight3InKgs.text = poundAmount3.roundToInt().toString()
        }

        binding.homeBtn.setOnClickListener {
            val intent2 = Intent(this@WorkoutSummary,
                MainActivity::class.java)
            startActivity(intent2)
        }
    }

}




