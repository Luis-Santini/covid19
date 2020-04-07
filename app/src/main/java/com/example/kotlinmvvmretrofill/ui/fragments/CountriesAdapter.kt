package com.example.kotlinmvvmretrofill.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmretrofill.R
import com.example.kotlinmvvmretrofill.model.covid.CovidCountries
import kotlinx.android.synthetic.main.list_item.view.*

class CountriesAdapter(private val onCountryClickListener: OnCountryClickListener) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {

    private var data: ArrayList<CovidCountries> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
        return CountriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) =
        holder.bind(data[position], onCountryClickListener, position)

    fun swapData(data: ArrayList<CovidCountries>) {
        this.data = data
        notifyDataSetChanged()
    }

    class CountriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtCountryName = itemView.txtCountryName
        private val txtDeaths = itemView.txtDeaths
        private val txtProvinceName = itemView.txtProvincesName
        private val txtConfirmed = itemView.txtConfirmed
        private val txtRecover = itemView.txtRecovered

        fun bind(
            item: CovidCountries,
            onCountryClickListener: OnCountryClickListener,
            position: Int
        ) {
            txtCountryName.text = item.countryregion
            txtProvinceName.text = item.provincestate
txtConfirmed.text = item.confirmed.toString()
            txtRecover.text = item.recovered.toString()
            txtDeaths.text = item.deaths.toString()



            itemView.setOnClickListener {
                onCountryClickListener.onCountryClickListener(position, item)
            }
        }
    }

    interface OnCountryClickListener {
        fun onCountryClickListener(position: Int, item: CovidCountries)
    }

}