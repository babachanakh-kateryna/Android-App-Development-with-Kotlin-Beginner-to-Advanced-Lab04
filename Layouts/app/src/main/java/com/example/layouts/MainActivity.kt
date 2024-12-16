package com.example.layouts

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

//    lateinit var myText : TextView
//    lateinit var doMagic: Button
//    lateinit var myButton: Button

//    lateinit var name:EditText
//    lateinit var ok:Button
//    lateinit var result:TextView
//    lateinit var image: ImageView

    lateinit var male:CheckBox
    lateinit var female:CheckBox
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
        male = findViewById(R.id.checkBox2)
        female = findViewById(R.id.checkBox1)
        result = findViewById(R.id.text1)

        male.setOnClickListener() {
            if (male.isChecked) {
                result.text = "Your gender is male"
                female.isChecked = false
            }else {
                result.text = "What is your gender?"
            }
        }

        female.setOnClickListener() {
            if (female.isChecked) {
                result.text = "Your gender is female"
                male.isChecked = false
            } else {
                result.text = "What is your gender?"
            }
        }
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
}