package com.example.dnevtukhova.currencydailylist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dnevtukhova.currencydailylist.api.CurrencyItem
import com.example.dnevtukhova.currencydailylist.presenter.CurrencyPresenter

class CurrencyViewModel(private val presenter: CurrencyPresenter) : ViewModel() {
    private val currencyLiveData = MutableLiveData<List<CurrencyItem>>()
    private val errorLiveData = MutableLiveData<String>()

    val currency: LiveData<List<CurrencyItem>>
        get() = currencyLiveData

    val error: LiveData<String>
        get() = errorLiveData

    fun getCurrency() {
        presenter.getCurrency(object: CurrencyPresenter.GetCurrencyCallback {
            override fun onSuccess(currency: List<CurrencyItem>) {
                Log.d("list IN VIEWMODEL", currency.get(0).toString())
                currencyLiveData.postValue(currency)
            }

            override fun onError(error: String) {
               errorLiveData.postValue(error)
            }
        })
    }
}