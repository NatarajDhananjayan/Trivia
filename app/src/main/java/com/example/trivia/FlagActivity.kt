package com.example.trivia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//Activity to choose the color of the Indian Flag
class FlagActivity : AppCompatActivity() {

    var flagArray: Array<String> = emptyArray()
    var selectedNumberOfColors = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)

        //Getting the user's name, the cricketer the user has selected
        //to pass into the summary Activity
        val intentThatStartedThisActivity = intent
        val userName = intentThatStartedThisActivity.getStringExtra("UserName")
        val bestCricketer = intentThatStartedThisActivity.getStringExtra("BestCricketer")

        val nextButton: Button = findViewById(R.id.nextSummaryButton)

        val yellowColorCB: CheckBox = findViewById(R.id.yellowColorCB)
        val orangeColorCB: CheckBox = findViewById(R.id.orangeColorCB)
        val greenColorCB: CheckBox = findViewById(R.id.greenColorCB)

        nextButton.setOnClickListener {
            val summaryIntent = Intent(this@FlagActivity, SummaryActivity::class.java)
            summaryIntent.putExtra("BestCricketer", bestCricketer)
            summaryIntent.putExtra("UserName", userName)
            flagArray = arrayOf("")


            selectedNumberOfColors = 0
            if(isWhiteChecked()) selectedNumberOfColors++
            if(isGreenChecked()) selectedNumberOfColors++
            if(isOrangeChecked()) selectedNumberOfColors++
            if(isYellowChecked()) selectedNumberOfColors++

            summaryIntent.putExtra("FlagArray", flagArray)

            //Ask the user to select 2 or more colors that
            //are available in the National Flag

            if(selectedNumberOfColors >= 2)  startActivity(summaryIntent)
            else Toast.makeText(this, "Please select two or more colors", Toast.LENGTH_SHORT).show()

        }
    }
    //Checking whether the user has chosen the White Color
    //and adding the color to the array if selected

    private fun isWhiteChecked() : Boolean {
        val whiteColorCB: CheckBox = findViewById(R.id.whiteColorCB)
        if (whiteColorCB.isChecked) {
            flagArray = flagArray.plus("White")
            return true
        }
        else return false

    }
    //Checking whether the user has chosen the Yellow Color
    //and adding the color to the array if selected

    private fun isYellowChecked() : Boolean {
        val yellowColorCB: CheckBox = findViewById(R.id.yellowColorCB)
        if (yellowColorCB.isChecked) {
            flagArray = flagArray.plus("Yellow")
            return true
        }
        else return false
    }

    //Checking whether the user has chosen the Orange Color
    //and adding the color to the array if selected

    private fun isOrangeChecked() : Boolean {
        val orangeColorCB: CheckBox = findViewById(R.id.orangeColorCB)
        if (orangeColorCB.isChecked) {
            flagArray = flagArray.plus("Orange")
            return true
        }
        else return false
    }
    //Checking whether the user has chosen the Green Color
    //and adding the color to the array if selected

    private fun isGreenChecked() : Boolean{
        val greenColorCB: CheckBox = findViewById(R.id.greenColorCB)
        if (greenColorCB.isChecked) {
            flagArray = flagArray.plus("Green")
            return true
        }
        else return false

    }
}