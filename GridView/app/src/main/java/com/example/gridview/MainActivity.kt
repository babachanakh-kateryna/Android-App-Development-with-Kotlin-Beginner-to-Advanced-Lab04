package com.example.gridview

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    var nameList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridView = findViewById(R.id.gridView)

        fillArrays()

        val adapter = AnimalsAdapter(this, nameList, imageList)
        gridView.adapter = adapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext, "You selected the ${nameList[position]}", Toast.LENGTH_LONG).show()
        }
    }

    fun fillArrays(){
        nameList.add("Tiger")
        nameList.add("Raccoon")
        nameList.add("Beaver")
        nameList.add("Giraffe")
        nameList.add("Gopher")
        nameList.add("Hedgehog")
        nameList.add("Koala")
        nameList.add("Owl")
        nameList.add("Squirrel")

        imageList.add(R.drawable.tiger)
        imageList.add(R.drawable.raccoon)
        imageList.add(R.drawable.beaver)
        imageList.add(R.drawable.giraffe)
        imageList.add(R.drawable.gopher)
        imageList.add(R.drawable.hedgehog)
        imageList.add(R.drawable.koala)
        imageList.add(R.drawable.owl)
        imageList.add(R.drawable.squirrel)

    }
}