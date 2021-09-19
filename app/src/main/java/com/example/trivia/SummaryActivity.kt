package com.example.trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

//Activity to show the Summary of the Trivia to the User
class   SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        //Get the all the user entered details so that it can be added to the database table

        val intentThatStartedThisActivity = intent
        val userName = intentThatStartedThisActivity.getStringExtra("UserName")
        val bestCricketer = intentThatStartedThisActivity.getStringExtra("BestCricketer")
        val flagArray = intentThatStartedThisActivity.getStringArrayExtra("FlagArray")

        val finishButton : Button = findViewById(R.id.buttonFinish)
        val historyButton : Button = findViewById(R.id.buttonHistory)
        val greetingText : TextView = findViewById(R.id.greetingTextView)
        val bestCricketerTextView : TextView = findViewById(R.id.bestCricketerAnswerTV)
        val flagColors : TextView = findViewById(R.id.colorsAnswerTV)

        var flagsSelected = ""

        //Add the user selected colors from the Array in the for, of CSV
        if (flagArray != null) {
            for(i in 0..(flagArray.size-1))
                if (i == 0) flagsSelected = flagsSelected.plus(flagArray[i])
                else if(i < (flagArray.size-1)) flagsSelected = flagsSelected.plus(flagArray[i] + ", ")
                else flagsSelected = flagsSelected.plus(flagArray[i])
        }

        //Set the summary with the user provided details
        greetingText.text = getString(R.string.hello_user, userName)
        bestCricketerTextView.text = bestCricketer
        flagColors.text = flagsSelected

        //Get the time when the user has taken the Trivia, format it and save it to the database
        //so that it can be used to show the user when the Trivia was taken
        val calendar = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("dd MMM, hh:mm a ")
        val date = simpleDateFormat.format(calendar.time)

        //Add the Trivia detailes to the database once the user taps on Finish
        finishButton.setOnClickListener {
            val intent = Intent(this@SummaryActivity, MainActivity::class.java)
            val helper = MyDbHelper(applicationContext)
            val dbWriter = helper.readableDatabase
            dbWriter.execSQL("INSERT INTO USERS(USERNAME,  TIME, CRICKETER, FLAGCOLORS) VALUES ('${userName}', '$date', '${bestCricketer}', '${flagsSelected}' )" )
            startActivity(intent)
        }
        //Show all the Trivias taken by the user by launching the SummaryActivity Intent
        historyButton.setOnClickListener {
            val intent = Intent(this@SummaryActivity, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}