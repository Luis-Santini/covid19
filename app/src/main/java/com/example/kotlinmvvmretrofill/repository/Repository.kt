package com.example.kotlinmvvmretrofill.repository


import com.example.kotlinmvvmretrofill.model.reponseHandler.Resource
import com.example.kotlinmvvmretrofill.model.reponseHandler.ResponseHandler
import com.example.kotlinmvvmretrofill.model.covid.CovidCountries
import com.example.kotlinmvvmretrofill.network.CovidService
import retrofit2.HttpException


class Repository (private val service: CovidService,
                  private val responseHandler: ResponseHandler
){


    suspend fun getLatest():Resource<List<CovidCountries>>{
        return try{
            val data = service.getLatest()
            responseHandler.handleSuccess(data)
        }
        catch (e: HttpException){
            responseHandler.handleException(e)
        }
    }





}