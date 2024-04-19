package edu.cofc.android.tonetime

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast
import edu.cofc.android.tonetime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var backName : TextView
    private lateinit var chestName : TextView
    private lateinit var armName : TextView
    private lateinit var legName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backName = binding.backTextView
        chestName = binding.chestTextView
        armName = binding.armsTextView
        legName = binding.legsTextView

        binding.backBtn.setOnClickListener {

            val backIntent = Intent(applicationContext, WorkoutPage::class.java)
            backIntent.putExtra("workout_type", backName.text.toString())
            startActivity(backIntent)
        }

        binding.armsBtn.setOnClickListener {
            val armIntent = Intent(applicationContext, WorkoutPage::class.java)
            armIntent.putExtra("workout_type", armName.text.toString())
            startActivity(armIntent)
        }

        binding.legsBtn.setOnClickListener {
            val legIntent = Intent(applicationContext, WorkoutPage::class.java)
            legIntent.putExtra("workout_type", legName.text.toString())
            startActivity(legIntent)
        }

        binding.chestBtn.setOnClickListener {
            val chestIntent = Intent(applicationContext, WorkoutPage::class.java)
            chestIntent.putExtra("workout_type", chestName.text.toString())
            startActivity(chestIntent)
        }

        binding.pickDateBtn.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this)
            datePickerDialog.setOnDateSetListener {_ , y, m, d ->
                Toast.makeText(this, "Date Picked: $y-${m + 1}-$d",
                    Toast.LENGTH_SHORT).show()
            }
            datePickerDialog.show()
        }
    }
}