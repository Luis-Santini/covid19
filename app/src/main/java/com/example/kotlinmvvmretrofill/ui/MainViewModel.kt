package com.example.kotlinmvvmretrofill.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlinmvvmretrofill.model.reponseHandler.Resource
import com.example.kotlinmvvmretrofill.repository.Repository
import kotlinx.coroutines.Dispatchers

class MainViewModel (private val repository: Repository): ViewModel(){
    
    val covidDate =  liveData(Dispatchers.IO) {
        emit(Resource.loading(null))

       // Log.d("mostrar", "${repository.getLatest()}")
        emit(repository.getLatest())
    }
}