package com.arlequins.resistorcolorcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arlequins.resistorcolorcode.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){
            valueToColorButton.setOnClickListener {
                goToValueToColorActivity()
            }
            colorToValueButton.setOnClickListener {
                goToColorToValueActivity()
            }
        }


    }

    private fun goToValueToColorActivity() {
        val intent = Intent(this, ValueToColorActivity::class.java)
        startActivity(intent)
    }

    private fun goToColorToValueActivity(){
        val intent = Intent(this, ColorToValueActivity::class.java)
        startActivity(intent)
    }


}