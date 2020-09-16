package com.example.dnevtukhova.currencydailylist

import android.app.Application
import com.example.dnevtukhova.currencydailylist.api.NetworkConstants.BASE_URL
import com.example.dnevtukhova.currencydailylist.api.ServerApi
import com.example.dnevtukhova.currencydailylist.presenter.CurrencyPresenter

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    companion object {
        lateinit var instance: App
            private set
    }
    lateinit var api: ServerApi
    lateinit var presenter: CurrencyPresenter


    override fun onCreate() {
        super.onCreate()
        instance = this
        initRetrofit()
        initPresenter()
    }
    private fun initRetrofit() {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                return@addInterceptor chain.proceed(
                    chain
                        .request()
                        .newBuilder()
                        .build()
                )
            }
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        if (BuildConfig.DEBUG) {
                            level = HttpLoggingInterceptor.Level.BASIC
                        }
                    })
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        api = retrofit.create(ServerApi::class.java)
    }

    private fun initPresenter() {
        presenter = CurrencyPresenter(api)
    }
}