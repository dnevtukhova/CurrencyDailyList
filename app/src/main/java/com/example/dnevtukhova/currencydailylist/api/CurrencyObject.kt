package com.example.dnevtukhova.currencydailylist.api

import com.google.gson.annotations.SerializedName

data class CurrencyObject(
    @SerializedName("Date") val date: String,
    @SerializedName("Valute") val results: Currency)


