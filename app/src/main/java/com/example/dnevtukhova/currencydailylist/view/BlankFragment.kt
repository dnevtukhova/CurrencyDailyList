package com.example.dnevtukhova.currencydailylist.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dnevtukhova.currencydailylist.App
import com.example.dnevtukhova.currencydailylist.R
import com.example.dnevtukhova.currencydailylist.api.CurrencyItem
import com.example.dnevtukhova.currencydailylist.viewmodel.CurrencyViewModel
import com.example.dnevtukhova.currencydailylist.viewmodel.CurrencyViewModelFactory
import kotlinx.android.synthetic.main.fragment_convert.*
import kotlinx.android.synthetic.main.fragment_currency_list.*

class FragmentConvert : Fragment() {
    lateinit var list: MutableList<String>
    lateinit var myFilms: List<CurrencyItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_convert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myViewModelFactory = CurrencyViewModelFactory(App.instance.presenter)

        val currencyViewModel = ViewModelProvider(
            requireActivity(),
            myViewModelFactory
        ).get(CurrencyViewModel::class.java)

        currencyViewModel.currency.observe(
            this.viewLifecycleOwner,
            Observer<List<CurrencyItem>> { films ->
                list = mutableListOf()
                myFilms = films
                for (i in films) {
                    list.add(i.name)
                }
                getSpinner(list, myFilms)
            })

        currencyViewModel.error.observe(
            this.viewLifecycleOwner,
            Observer<String> { error ->
                if (progressbar != null) {
                    progressbar.visibility = View.GONE
                }
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            })
        currencyViewModel.getCurrency()
    }

    private fun getSpinner(list: MutableList<String>, films: List<CurrencyItem>) {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_item,
            list.toTypedArray()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d(TAG, "ничего не выбрано")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                btnConvert.setOnClickListener {
                    for (i in films) {

                        if (i.name == list[p2]) {
                            val nominal = i.nominal
                            val course = i.value.toFloat()
                            if (checkSum.text.toString() == "") {
                                Toast.makeText(
                                    context,
                                    "Введите сумму в рублях для конвертации",
                                    Toast.LENGTH_LONG
                                ).show()
                            } else {
                                val sum = checkSum.text.toString().toFloat()
                                Log.d(TAG, "sum $sum")
                                val finalSum = (sum * nominal) / course
                                val finalString = String.format("%.2f", finalSum) + " ${i.charCode}"
                                sumFinal.text = finalString
                                Log.d(TAG, finalString)
                            }
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val TAG = "FragmentConvert"
    }

}