package com.example.dnevtukhova.currencydailylist.presenter

import android.util.Log
import com.example.dnevtukhova.currencydailylist.api.CurrencyItem
import com.example.dnevtukhova.currencydailylist.api.CurrencyObject
import com.example.dnevtukhova.currencydailylist.api.ServerApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyPresenter(val api: ServerApi) {
fun getCurrency(callback: GetCurrencyCallback) {
    api.getCurrency().enqueue(object : Callback<CurrencyObject> {
        override fun onFailure(call: Call<CurrencyObject>, t: Throwable) {
            callback.onError("!!! произошла ошибка $t")
        }

        override fun onResponse(call: Call<CurrencyObject>, response: Response<CurrencyObject>) {
            if (response.isSuccessful) {
                val currencyList = mutableListOf<CurrencyItem>()
                currencyList.add(response.body()!!.results.AMD)
                currencyList.add(response.body()!!.results.AUD)
                currencyList.add(response.body()!!.results.AZN)
                currencyList.add(response.body()!!.results.BGN)
                currencyList.add(response.body()!!.results.BRL)
                currencyList.add(response.body()!!.results.BYN)
                currencyList.add(response.body()!!.results.CAD)
                currencyList.add(response.body()!!.results.CHF)
                currencyList.add(response.body()!!.results.CNY)
                currencyList.add(response.body()!!.results.CZK)
                currencyList.add(response.body()!!.results.DKK)
                currencyList.add(response.body()!!.results.EUR)
                currencyList.add(response.body()!!.results.GBP)
                currencyList.add(response.body()!!.results.HKD)
                currencyList.add(response.body()!!.results.HUF)
                currencyList.add(response.body()!!.results.INR)
                currencyList.add(response.body()!!.results.JPY)
                currencyList.add(response.body()!!.results.KGS)
                currencyList.add(response.body()!!.results.KRW)
                currencyList.add(response.body()!!.results.KZT)
                currencyList.add(response.body()!!.results.MDL)
                currencyList.add(response.body()!!.results.NOK)
                currencyList.add(response.body()!!.results.PLN)
                currencyList.add(response.body()!!.results.RON)
                currencyList.add(response.body()!!.results.SEK)
                currencyList.add(response.body()!!.results.SGD)
                currencyList.add(response.body()!!.results.TJS)
                currencyList.add(response.body()!!.results.TMT)
                currencyList.add(response.body()!!.results.TRY)
                currencyList.add(response.body()!!.results.UAH)
                currencyList.add(response.body()!!.results.USD)
                currencyList.add(response.body()!!.results.UZS)
                currencyList.add(response.body()!!.results.XDR)
                currencyList.add(response.body()!!.results.ZAR)

                callback.onSuccess(currencyList)

            }
            else {
                callback.onError("!!! произошла ошибка ${response.code()}")
            }
        }
    })
}

    interface GetCurrencyCallback {
        fun onSuccess(currency: List<CurrencyItem>)
        fun onError(error: String)
    }
}