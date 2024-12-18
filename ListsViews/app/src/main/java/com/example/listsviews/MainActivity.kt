package com.example.listsviews

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var recyckerView: RecyclerView
    var countryNameList = ArrayList<String>()
    var detailList= ArrayList<String>()
    var imageList =  ArrayList<Int>()

    lateinit var adapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyckerView = findViewById(R.id.recycle)

        recyckerView.layoutManager = LinearLayoutManager(this@MainActivity)

        countryNameList.add("Ukraine")
        countryNameList.add("UK")
        countryNameList.add("France")

        detailList.add("Ukraine is a country in Eastern Europe.")
        detailList.add("The United Kingdom is a country in Western Europe.")
        detailList.add("France is a country in Western Europe.")

        imageList.add(R.drawable.flag_of_ukraine)
        imageList.add(R.drawable.flag_of_the_united_kingdom)
        imageList.add(R.drawable.flag_of_france)

        adapter = CountriesAdapter(countryNameList, detailList, imageList, this@MainActivity)
        recyckerView.adapter = adapter
    }
}