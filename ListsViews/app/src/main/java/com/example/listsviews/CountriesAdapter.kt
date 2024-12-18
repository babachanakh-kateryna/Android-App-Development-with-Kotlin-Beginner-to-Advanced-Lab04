package com.example.listsviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList

class CountriesAdapter (
    var countryNameList: ArrayList<String>,
    var detailList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCountryName: TextView = itemView.findViewById(R.id.CountryName)
        var textViewCountryDetail: TextView = itemView.findViewById(R.id.Detail)
        var imageView: CircleImageView = itemView.findViewById(R.id.imageView)
        var cardView: View = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_disign, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewCountryDetail.text = detailList.get(position)
        holder.imageView.setImageResource(imageList.get(position))

        holder.cardView.setOnClickListener {
            Toast.makeText(context, "You selected the ${countryNameList.get(position)}", Toast.LENGTH_LONG).show()
        }
    }


}