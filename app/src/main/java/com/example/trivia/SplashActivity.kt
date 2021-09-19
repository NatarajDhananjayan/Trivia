package com.example.trivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

//Activity for showing the Splash screen when the app launches

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Hide the action bar as we need not to show it during the splash screen
        supportActionBar?.hide()

        //Delaying the MainActivity so that the splash screen is shown for quite a while
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            //Finish the activity as we need not to go back to it until the app restarts
            finish()
            }, 3000)
    }
}