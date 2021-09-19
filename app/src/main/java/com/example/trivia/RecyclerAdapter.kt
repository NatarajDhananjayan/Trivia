package com.example.trivia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Recylcer Adapter class to help us show a list a user played Trivias
//in a recycler View

class RecyclerAdapter(
    gameNumber : Array<Int>,
    userName: Array<String>,
    cricketerName: Array<String>,
    flagColors: Array<String>,
    dateAndTime: Array<String>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    //Store all the arrays that gets passed through the primary Constructor

    private var mGameNumber : Array<Int> = gameNumber
    private var mUserName : Array<String> = userName
    private var mCricketerName : Array<String> = cricketerName
    private var mFlagColors : Array<String> = flagColors
    private var mDateAndTime : Array<String> = dateAndTime


   //Inflate the custom layout we have created to show individual Trivia the
   //the user has played

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trivia_list,
        parent, false)
        return ViewHolder(view)
    }

    //Using the ViewHolder, set the values on to the custom Layout we have designed
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.gameNumber.text = "Game : ${mGameNumber[position]}"
        holder.userName.text = mUserName[position]
        holder.cricketerName.text = mCricketerName[position]
        holder.flagColors.text = mFlagColors[position]
        holder.dateAndTime.text = mDateAndTime[position]
    }

    //Return the size of the user Arrays
    //so that the recycler View knows the number of items in the View
    override fun getItemCount(): Int {
        return mUserName.size
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        var gameNumber : TextView
        var userName : TextView
        var cricketerName : TextView
        var flagColors : TextView
        var dateAndTime : TextView

        init{
            gameNumber = itemView.findViewById(R.id.gameNumberTV)
            userName = itemView.findViewById(R.id.userNameTV)
            cricketerName = itemView.findViewById(R.id.bestCricketerAnswerTV)
            flagColors = itemView.findViewById(R.id.colorsAnswerTV)
            dateAndTime = itemView.findViewById(R.id.dateAndTimeTV)
        }

    }
}
