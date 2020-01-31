package com.example.week4project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val principal = findViewById<EditText>(R.id.editTextPrincipal)
        val rateOfInterest = findViewById<EditText>(R.id.editTextROI)
        val numOfTerms = findViewById<EditText>(R.id.editTextNumOfTerms)

        var spinner = findViewById<Spinner>(R.id.spinnerPaymentPeriod)

        val colors = arrayOf("Weekly", "Bi-Weekly", "Monthly", "Yearly")

        if(spinner != null) {
            val spinnerArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = spinnerArrayAdapter
        }
        /*val colors =
            arrayOf("Weekly", "Bi-weekly", "Monthly", "Yearly")

        if(spinner != null)
        {
            val spinnerArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
            spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) // The drop down view
            spinner.adapter = spinnerArrayAdapter
        }*/

        var checkBox = findViewById<CheckBox>(R.id.cbSICI)

        btnSubmit.setOnClickListener {
            val interest = SimpleInterest(
                principal.text.toString().toDouble(),
                numOfTerms.text.toString().toDouble(),
                rateOfInterest.text.toString().toDouble())

            val makeToast = Toast.makeText(this, interest.toString(), Toast.LENGTH_SHORT)
            makeToast.show()
        }

    }

    fun SimpleInterest(p:Double,n:Double,r:Double): Double {
        return (p*r*n)/100
    }

    fun CompoundInterest(p:Double, n:Double, r:Double): Double{
        return 0.0
    }
}
