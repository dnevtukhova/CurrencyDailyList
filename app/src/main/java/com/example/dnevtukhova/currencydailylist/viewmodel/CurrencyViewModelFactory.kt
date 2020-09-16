package com.example.dnevtukhova.currencydailylist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dnevtukhova.currencydailylist.presenter.CurrencyPresenter

class CurrencyViewModelFactory (private val presenter: CurrencyPresenter) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(CurrencyPresenter::class.java)
            .newInstance(presenter)
    }
}