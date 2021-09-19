package com.example.trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.nextButton)
        val nameEditText : EditText = findViewById(R.id.nameEditText)

        //Ask the user for their name and navigate to the
        //cricketer Activity once the user has provided their name
        button.setOnClickListener {
        val name : String = nameEditText.text.toString()

            if(name.isEmpty()) {
                Toast.makeText(this, "Please enter your Name", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this@MainActivity, CricketerActivity::class.java)
                intent.putExtra("UserName", nameEditText.text.toString())
                startActivity(intent)
            }
        }
    }

}