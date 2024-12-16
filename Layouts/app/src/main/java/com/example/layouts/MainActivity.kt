package com.example.layouts

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

//    lateinit var myText : TextView
//    lateinit var doMagic: Button
//    lateinit var myButton: Button

//    lateinit var name:EditText
//    lateinit var ok:Button
//    lateinit var result:TextView
//    lateinit var image: ImageView
//
//    lateinit var male:CheckBox
//    lateinit var female:CheckBox
//    lateinit var result: TextView

//    lateinit var linearLayout: LinearLayout
//    lateinit var green : RadioButton
//    lateinit var red : RadioButton
//    lateinit var yellow : RadioButton
//    lateinit var change: Button

    lateinit var spinner: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.spinnerCountry)
        result = findViewById(R.id.textView)

        spinner.onItemSelectedListener = this
        var arrayAdapter = ArrayAdapter.createFromResource(this, R.array.contries, android.R.layout.simple_spinner_item)

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter


//        linearLayout = findViewById(R.id.main)
//        green = findViewById(R.id.green)
//        red = findViewById(R.id.red)
//        yellow = findViewById(R.id.yellow)
//        change = findViewById(R.id.btn)
//
//        change.setOnClickListener() {
//            if (green.isChecked) {
//                linearLayout.setBackgroundColor(Color.GREEN)
//            } else if (red.isChecked) {
//                linearLayout.setBackgroundColor(Color.RED)
//            } else if (yellow.isChecked) {
//                linearLayout.setBackgroundColor(Color.YELLOW)
//            }
//        }

//        male = findViewById(R.id.checkBox2)
//        female = findViewById(R.id.checkBox1)
//        result = findViewById(R.id.text1)
//
//        male.setOnClickListener() {
//            if (male.isChecked) {
//                result.text = "Your gender is male"
//                female.isChecked = false
//            }else {
//                result.text = "What is your gender?"
//            }
//        }
//
//        female.setOnClickListener() {
//            if (female.isChecked) {
//                result.text = "Your gender is female"
//                male.isChecked = false
//            } else {
//                result.text = "What is your gender?"
//            }
//        }
//        name = findViewById(R.id.editTextName)
//        ok = findViewById(R.id.ok)
//        result = findViewById(R.id.result)
//
//        image = findViewById(R.id.imageFox)
//        ok.setOnClickListener {
//            var userName: String = name.text.toString()
//
//            result.text = "Hello $userName"
//
//            image.setImageResource(R.drawable.second)
//        }

//        myText = findViewById(R.id.textEx)
//        myText.setTextColor(Color.RED)
//
//        myText.setOnClickListener {
//            myText.setTextColor(Color.BLUE)
//        }

//        doMagic = findViewById(R.id.doMagic)
//        myButton = findViewById(R.id.myButton)
//        myText = findViewById(R.id.textEx)
//
//        doMagic.setOnClickListener {
//            doMagic.setBackgroundColor(Color.RED)
//            myText.setText("Magic")
//
//            myText.isVisible = false
//            doMagic.isVisible = false
//        }
//
//        myButton.setOnClickListener {
//            myText.isVisible = true
//            doMagic.isVisible = true
//        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            result.text = parent.getItemAtPosition(position).toString()
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}