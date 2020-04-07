package com.example.kotlinmvvmretrofill.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.ListFragment
import androidx.lifecycle.Observer
import com.example.kotlinmvvmretrofill.R
import com.example.kotlinmvvmretrofill.model.reponseHandler.Resource
import com.example.kotlinmvvmretrofill.model.covid.CovidCountries
import com.example.kotlinmvvmretrofill.ui.fragments.ListFragment.Companion.newInstance

import org.koin.android.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  // viewModel.covidDate.observe(this,latercovid)

   val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.parentView, com.example.kotlinmvvmretrofill.ui.fragments.ListFragment.newInstance())
ft.commit()

    }




}


