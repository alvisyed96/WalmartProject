package com.syed.walmartproject.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syed.walmartproject.data.model.APIResponseItem
import com.syed.walmartproject.R

class CountryRecyclerViewAdapter(private var countries: ArrayList<APIResponseItem>) :
    RecyclerView.Adapter<CountryRecyclerViewAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_countries_user, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val countryItems = countries[position]
        holder.bind(countryItems)
    }

    fun updateCountries(newCountries: ArrayList<APIResponseItem>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.tvName)
        private val code: TextView = itemView.findViewById(R.id.tvCode)
        private val capital: TextView = itemView.findViewById(R.id.tvCapital)

        fun bind(countryItems: APIResponseItem) {
            name.text = countryItems.name
            code.text = countryItems.code
            capital.text = countryItems.capital
        }
    }
}