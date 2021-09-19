package com.example.trivia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


//Activity that shows the History of all the Trivias played

class HistoryActivity : AppCompatActivity() {

    private var layoutManager : RecyclerView.LayoutManager? = null


    var mGameNumber : Array<Int> = emptyArray()
    var mUserName : Array<String> = emptyArray()
     var mCricketerName : Array<String> = emptyArray()
     var mFlagColors : Array<String> = emptyArray()
     var mDateAndTime : Array<String> = emptyArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //Creating a reference to the RecyclerView and
        //setting the Layout Manager to it

        var recyclerView = findViewById<RecyclerView> (R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager


    val helper = MyDbHelper(applicationContext)
    val dbReader = helper.readableDatabase

    val cursor = dbReader.rawQuery("SELECT * FROM USERS", null)

        //Adding all the user inputs to the array while moving the cursor along the table

        while(cursor.moveToNext()){
            mGameNumber = mGameNumber.plus(cursor.getInt(0))
            mUserName = mUserName.plus(cursor.getString(1))
            mDateAndTime = mDateAndTime.plus(cursor.getString(2))
            mCricketerName = mCricketerName.plus(cursor.getString(3))
            mFlagColors = mFlagColors.plus(cursor.getString(4))
        }
        //Close the cursor as we do not need it anymore
        cursor.close()

        val recyclerAdapter = RecyclerAdapter(mGameNumber, mUserName, mCricketerName, mFlagColors, mDateAndTime)
        recyclerView.adapter = recyclerAdapter
    }
}