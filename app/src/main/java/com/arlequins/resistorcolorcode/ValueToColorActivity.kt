package com.arlequins.resistorcolorcode

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arlequins.resistorcolorcode.databinding.ActivityValueToColorBinding

@SuppressLint("StaticFieldLeak")
private lateinit var valueToColorBinding: ActivityValueToColorBinding

class ValueToColorActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        valueToColorBinding = ActivityValueToColorBinding.inflate(layoutInflater)
        val view = valueToColorBinding.root
        setContentView(view)

        val colorMap:Map<String,String> = mapOf(
            Pair("0", "#212121"), /*negro*/
            Pair("1", "#6d4c41"), /*cafe*/
            Pair("2", "#d50000"), /*rojo*/
            Pair("3", "#FF9800"), /*naranja*/
            Pair("4", "#ffff00"), /*amarillo*/
            Pair("5", "#64dd17"), /*verde*/
            Pair("6", "#0091ea"), /*azul*/
            Pair("7", "#d500f9"), /*morado*/
            Pair("8", "#424242"), /*gris*/
            Pair("9", "#fafafa"), /*blanco*/
            Pair("1%", "#5d4037"), /*tolCafe*/
            Pair("2%", "#d5001c"), /*tolRoja*/
            Pair("5%", "#FFEB3B"), /*tolGolden*/
            Pair("10%", "#bdbdbd"), /*tolDorada*/
        )
        val colorMapMult:Map<String,String> = mapOf(
            Pair("1", "#212121"), /*negro*/
            Pair("10", "#6d4c41"), /*cafe*/
            Pair("100", "#d50000"), /*rojo*/
            Pair("1 K", "#ff9800"), /*naranja*/
            Pair("10 K", "#ffff00"), /*amarillo*/
            Pair("100 K", "#64dd17"), /*verde*/
            Pair("1 M", "#0091ea"), /*azul*/
            Pair("10 M", "#d500f9"), /*morado*/
            Pair("100 M", "#424242"), /*gris*/
            Pair("1 G", "#fafafa"), /*blanco*/
            Pair("0.1", "#FFEB3B"), /*tolGolden*/
            Pair("0.01", "#bdbdbd"), /*tolDorada*/
        )

        with(valueToColorBinding){
            calculateVTCButton.setOnClickListener(){
                val band1 = band1Spinner.selectedItem.toString()
                val band2 = band2Spinner.selectedItem.toString()
                val multiplier = multiplierSpinner.selectedItem.toString()
                val tolerance = toleranceSpinner.selectedItem.toString()

                val mult: List<String> = clearMultiplier(multiplier)
                val len = mult.size
                val num = band1 + band2

                var numPart = num.toFloat()*mult[0].toFloat()
                if (numPart/1000 >= 1){
                    numPart /= 1000
                    if (len == 1) valueNumericTextView.text = numPart.toString() +"KΩ - "+ tolerance
                    else if (len == 2 && mult[1] == "K") valueNumericTextView.text = numPart.toString() +"MΩ - "+ tolerance
                    else if (len == 2 && mult[1] == "M") valueNumericTextView.text = numPart.toString() +"GΩ - "+ tolerance
                }
                else if (len < 2) valueNumericTextView.text = numPart.toString() +"Ω - "+ tolerance
                else valueNumericTextView.text = numPart.toString() + mult[1]+"Ω - "+ tolerance

                band1ImageView.setBackgroundColor(Color.parseColor(colorMap[band1]))
                band2ImageView.setBackgroundColor(Color.parseColor(colorMap[band2]))
                multiplierImageView.setBackgroundColor(Color.parseColor(colorMapMult[multiplier]))
                toleranceImageView.setBackgroundColor(Color.parseColor(colorMap[tolerance]))
            }
        }
    }

    private fun clearMultiplier(multiplier: String): List<String> {
        return multiplier.split(" ")
    }


}