package com.example.kotlinmvvmretrofill.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlinmvvmretrofill.R
import com.example.kotlinmvvmretrofill.model.covid.CovidCountries
import com.example.kotlinmvvmretrofill.model.reponseHandler.Resource
import com.example.kotlinmvvmretrofill.ui.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel


class ListFragment : Fragment(), CountriesAdapter.OnCountryClickListener {

    lateinit var countriesAdapter: CountriesAdapter
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewRoot = inflater.inflate(R.layout.fragment_list, container, false)
        return viewRoot

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.covidDate.observe(viewLifecycleOwner, latercovid)
        countriesAdapter = CountriesAdapter(this)
        // recyclerList.apply {
        recyclerList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerList.adapter = countriesAdapter
    //    countriesAdapter.swapData()
        //  }
    }


    private val latercovid = Observer<Resource<List<CovidCountries>>> { response ->
        when (response.status) {

            Resource.Status.ERROR -> {
                Log.e("MainActivity", "  The error is: ${response.message}")
            }
            Resource.Status.SUCCESS -> {
                if (response.data != null) {
                    countriesAdapter.swapData(response.data as ArrayList<CovidCountries>)
                }

            }
            Resource.Status.LOADING -> {
                Log.d("MainActivity", "Is loading...")
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onCountryClickListener(position: Int, item: CovidCountries) {
Log.d("mensaje", "clic")
    }

}
