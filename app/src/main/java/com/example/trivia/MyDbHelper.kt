package com.example.trivia


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//Database Helper Class to create a DataBase if it does not exist
class MyDbHelper(context : Context) : SQLiteOpenHelper(context, "USERDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(GAMENUMBER INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, TIME TEXT, CRICKETER TEXT, FLAGCOLORS TEXT)")
        }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}