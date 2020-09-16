package com.example.dnevtukhova.currencydailylist.api

import retrofit2.Call
import retrofit2.http.GET

interface ServerApi {
@GET("daily_json.js")
fun getCurrency(): Call<CurrencyObject>
}