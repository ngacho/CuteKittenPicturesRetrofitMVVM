package com.brocodes.catspics.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val splashScreenBinding = DataBindingUtil.setContentView<ActivitySplashScreenBinding>(
            this,
            R.layout.activity_splash_screen
        )

        val progressBar = splashScreenBinding.progressSplashscreen
        progressBar.visibility = View.VISIBLE


        //4second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this, MainActivity::class.java))
            //finish this activity
            finish()
            progressBar.visibility = View.GONE
        }, 5000)

    }
}
