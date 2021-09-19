package com.example.trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

//Activity to choose the best Cricketer

class CricketerActivity : AppCompatActivity() {

    lateinit var radioGroup : RadioGroup
    lateinit var selectedCricketer : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricketer)

        val intentThatStartedThisActivity = intent
        val userName = intentThatStartedThisActivity.getStringExtra("UserName")
        val  button : Button = findViewById(R.id.nextButton)
        radioGroup = findViewById(R.id.radioGroup)

        //Passing the User Name and the Cricketer Name the User
        // has chosen, into the Flag activity

        button.setOnClickListener {
            if(radioGroup.checkedRadioButtonId != -1) {
                val flagIntent = Intent(this@CricketerActivity,
                    FlagActivity::class.java)
                flagIntent.putExtra("BestCricketer", selectedCricketer())
                flagIntent.putExtra("UserName", userName)
                startActivity(flagIntent)
            }

            //Asking the user to select a cricketer if not chosen any
            else Toast.makeText(this, "Please select a cricketer", Toast.LENGTH_SHORT).show()

        }
    }

    //A helper function thet would return the name of the Cricketer
    //based on the Radio Button the user has selected
    private fun selectedCricketer() : String{
        when(radioGroup.checkedRadioButtonId){
            R.id.sachinRB -> selectedCricketer = "Sachin Tendulkar"
            R.id.viratKohliRB -> selectedCricketer = "Virat Kohli"
            R.id.adamGilchristRB -> selectedCricketer = "Adam Gilchrist"
            R.id.jacquesKallisRB -> selectedCricketer = "Jacques Kallis"
        }
        return selectedCricketer
    }
}