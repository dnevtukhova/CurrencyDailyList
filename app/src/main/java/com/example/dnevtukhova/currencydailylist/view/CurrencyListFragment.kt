package com.example.dnevtukhova.currencydailylist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dnevtukhova.currencydailylist.App
import com.example.dnevtukhova.currencydailylist.R
import com.example.dnevtukhova.currencydailylist.api.CurrencyItem
import com.example.dnevtukhova.currencydailylist.viewmodel.CurrencyViewModel
import com.example.dnevtukhova.currencydailylist.viewmodel.CurrencyViewModelFactory
import kotlinx.android.synthetic.main.fragment_currency_list.*

class CurrencyListFragment : Fragment() {
    private lateinit var recycler: RecyclerView
    private lateinit var adapterCurrency: CurrencyListRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(view)
        val myViewModelFactory = CurrencyViewModelFactory(App.instance.presenter)

        val currencyViewModel = ViewModelProvider(
            requireActivity(),
            myViewModelFactory
        ).get(CurrencyViewModel::class.java)

        currencyViewModel.currency.observe(
            this.viewLifecycleOwner,
            Observer<List<CurrencyItem>> { films -> adapterCurrency.setItems(films)
            Log.d("in fragment", films[0].toString())})

        currencyViewModel.error.observe(
            this.viewLifecycleOwner,
            Observer<String> { error ->
                if (progressbar != null) {
                    progressbar.visibility = View.GONE
                }
                Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            })
        currencyViewModel.getCurrency()
        if (progressbar != null) {
            progressbar.visibility = View.GONE
        }
        adapterCurrency.notifyDataSetChanged()

        swipeRefreshLayout.setOnRefreshListener {
            if (progressbar != null) {
                progressbar.visibility = View.GONE
            }
            currencyViewModel.getCurrency()
            swipeRefreshLayout.isRefreshing = false
        }

        convertButton.setOnClickListener { requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                FragmentConvert(),
                FragmentConvert.TAG
            )
            .addToBackStack(FragmentConvert.TAG)
            .commit() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    private fun initRecycler (view: View) {
        recycler = view.findViewById(R.id.currencyList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler.layoutManager = layoutManager
        adapterCurrency = CurrencyListRecyclerViewAdapter(LayoutInflater.from(context))
        recycler.adapter= adapterCurrency
        adapterCurrency.notifyDataSetChanged()
    }

    companion object {
        const val TAG = "CurrencyListFragment"
    }
}