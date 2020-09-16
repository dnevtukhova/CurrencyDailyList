package com.example.dnevtukhova.currencydailylist.api

import com.google.gson.annotations.SerializedName

data class Currency  (

    @SerializedName("AUD")val AUD: CurrencyItem,
    @SerializedName("AZN")val AZN: CurrencyItem,
    @SerializedName("GBP")val GBP: CurrencyItem,
    @SerializedName("AMD")val AMD: CurrencyItem,
    @SerializedName("BYN")val BYN: CurrencyItem,
    @SerializedName("BGN")val BGN: CurrencyItem,
    @SerializedName("BRL")val BRL: CurrencyItem,
    @SerializedName("HUF")val HUF: CurrencyItem,
    @SerializedName("HKD")val HKD: CurrencyItem,
    @SerializedName("DKK")val DKK: CurrencyItem,
    @SerializedName("USD")val USD: CurrencyItem,
    @SerializedName("EUR")val EUR: CurrencyItem,
    @SerializedName("INR")val INR: CurrencyItem,
    @SerializedName("KZT")val KZT: CurrencyItem,
    @SerializedName("CAD")val CAD: CurrencyItem,
    @SerializedName("KGS")val KGS: CurrencyItem,
    @SerializedName("CNY")val CNY: CurrencyItem,
    @SerializedName("MDL")val MDL: CurrencyItem,
    @SerializedName("NOK")val NOK: CurrencyItem,
    @SerializedName("PLN")val PLN: CurrencyItem,
    @SerializedName("RON")val RON: CurrencyItem,
    @SerializedName("XDR")val XDR: CurrencyItem,
    @SerializedName("SGD")val SGD: CurrencyItem,
    @SerializedName("TJS")val TJS: CurrencyItem,
    @SerializedName("TRY")val TRY: CurrencyItem,
    @SerializedName("TMT")val TMT: CurrencyItem,
    @SerializedName("UZS")val UZS: CurrencyItem,
    @SerializedName("UAH")val UAH: CurrencyItem,
    @SerializedName("CZK")val CZK: CurrencyItem,
    @SerializedName("SEK")val SEK: CurrencyItem,
    @SerializedName("CHF")val CHF: CurrencyItem,
    @SerializedName("ZAR")val ZAR: CurrencyItem,
    @SerializedName("KRW")val KRW: CurrencyItem,
    @SerializedName("JPY")val JPY: CurrencyItem
)