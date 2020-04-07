package com.example.kotlinmvvmretrofill.di
import com.example.kotlinmvvmretrofill.model.reponseHandler.ResponseHandler
import com.example.kotlinmvvmretrofill.network.CovidInterceptor
import com.example.kotlinmvvmretrofill.network.CovidService
import com.example.kotlinmvvmretrofill.repository.Repository
import com.example.kotlinmvvmretrofill.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModuel = module {
viewModel { MainViewModel(get()) }
}

val covidModule = module {

    single (named("covid")) {

        provideRetrofit(
        get(),
        "https://wuhan-coronavirus-api.laeyoung.endpoint.ainize.ai/"
        )
    }
        single { get<Retrofit>(named("covid")).create(CovidService::class.java) }
        single { provideOkHttpClient(get()) }
        single { ResponseHandler() }
        single { Repository(get(), get()) }
        single { CovidInterceptor() }

}

fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit{

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(
    interceptor:CovidInterceptor): OkHttpClient {
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    okHttpClientBuilder.addInterceptor(interceptor)
    return okHttpClientBuilder.build()
}

