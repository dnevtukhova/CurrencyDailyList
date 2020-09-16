package com.example.dnevtukhova.currencydailylist.api

import com.google.gson.annotations.SerializedName

data class CurrencyItem(
    @SerializedName("CharCode") val charCode: String,
    @SerializedName("Nominal") val nominal: Int,
    @SerializedName("Name") val name: String,
    @SerializedName("Value") val value: String,
    @SerializedName("Previous") val previousValue: String
)