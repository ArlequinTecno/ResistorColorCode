package com.arlequins.resistorcolorcode

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlequins.resistorcolorcode.databinding.ActivityColorToValueBinding

@SuppressLint("StaticFieldLeak")
private lateinit var colorToValueBinding: ActivityColorToValueBinding

class ColorToValueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorToValueBinding = ActivityColorToValueBinding.inflate(layoutInflater)
        val view = colorToValueBinding.root
        setContentView(view)

        val strColorMap:Map<String,String> = mapOf(
            Pair("Negro", "#212121"), /*negro*/
            Pair("Café", "#6d4c41"), /*cafe*/
            Pair("Rojo", "#d50000"), /*rojo*/
            Pair("Naranja", "#FF9800"), /*naranja*/
            Pair("Amarillo", "#ffff00"), /*amarillo*/
            Pair("Verde", "#64dd17"), /*verde*/
            Pair("Azul", "#0091ea"), /*azul*/
            Pair("Morado", "#d500f9"), /*morado*/
            Pair("Gris", "#424242"), /*gris*/
            Pair("Blanco", "#fafafa"), /*blanco*/
            Pair("Dorado", "#FFEB3B"), /*tolGolden*/
            Pair("Plateado", "#bdbdbd"), /*tolDorada*/
        )

        val strColorNumMap:Map<String, String> = mapOf(
            Pair("Negro", "0"), /*negro*/
            Pair("Café", "1"), /*cafe*/
            Pair("Rojo", "2"), /*rojo*/
            Pair("Naranja", "3"), /*naranja*/
            Pair("Amarillo", "4"), /*amarillo*/
            Pair("Verde", "5"), /*verde*/
            Pair("Azul", "6"), /*azul*/
            Pair("Morado", "7"), /*morado*/
            Pair("Gris", "8"), /*gris*/
            Pair("Blanco", "9"), /*blanco*/
            Pair("Dorado", "-1"), /*tolGolden*/
            Pair("Plateado", "-2"), /*tolDorada*/
        )

        with(colorToValueBinding){
            colorCalculateButton.setOnClickListener{

                val colorBand1 = colorBand1Spinner.selectedItem.toString()
                val colorBand2 = colorBand2Spinner.selectedItem.toString()
                val colorMultiplier = colorMultiplierSpinner.selectedItem.toString()
                val colorTolerance = colorToleranceSpinner.selectedItem.toString()

                colorBand1ImageView.setBackgroundColor(Color.parseColor(strColorMap[colorBand1]))
                colorBand2ImageView.setBackgroundColor(Color.parseColor(strColorMap[colorBand2]))
                colorMultiplierImageView.setBackgroundColor(Color.parseColor(strColorMap[colorMultiplier]))
                colorToleranceImageView.setBackgroundColor(Color.parseColor(strColorMap[colorTolerance]))

                val exp = strColorNumMap[colorMultiplier].toString().toDouble()
                val mult = Math.pow(10.0,exp)
                val val1 = strColorNumMap[colorBand1].toString()
                val val2 = strColorNumMap[colorBand2].toString()

                val numPart = val1+val2
                val value = numPart.toDouble()*mult
                var valStr = " "

                if (value/1000000000 >= 1) {
                    valStr = (value/1000000000).toString()+"GΩ"
                }
                else if (value/1000000 >= 1){
                    valStr = (value/1000000).toString()+"MΩ"
                }
                else if (value/1000 >= 1) {
                    valStr = (value/1000).toString()+"KΩ"
                }
                else {
                    valStr = value.toString()+"Ω"
                }

                colorSolutionTexrView.text = valStr
            }
        }

    }
}