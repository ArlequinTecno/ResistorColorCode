package com.arlequins.resistorcolorcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arlequins.resistorcolorcode.databinding.ActivitySplashBinding
import java.util.*
import kotlin.concurrent.timerTask




class SplashActivity : AppCompatActivity() {

    private lateinit var splashBind: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBind = ActivitySplashBinding.inflate(layoutInflater)
        val view = splashBind.root
        setContentView(view)

        val timer = Timer()

        timer.schedule(timerTask{
            goToMainActivity()
        }, 1000
        )



    }

    private fun goToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}