package com.example.dnevtukhova.currencydailylist.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dnevtukhova.currencydailylist.R
import com.example.dnevtukhova.currencydailylist.api.CurrencyItem
import java.util.*

class CurrencyListRecyclerViewAdapter(private val inflater: LayoutInflater) :
    RecyclerView.Adapter<CurrencyViewHolder>() {
    private val items = ArrayList<CurrencyItem>()

    fun setItems(films: List<CurrencyItem>) {
        items.clear()
        items.addAll(films)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        return CurrencyViewHolder(
            inflater
                .inflate(R.layout.fragment_currency_item, parent, false)
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}

class CurrencyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val charCode: TextView = view.findViewById(R.id.charCode)
    private val nameCurrency: TextView = view.findViewById(R.id.nameCurrency)
    private val value: TextView = view.findViewById(R.id.currencyValue)
    private val nominal: TextView = view.findViewById(R.id.nominal)

    fun bind(currency: CurrencyItem) {
        charCode.text = currency.charCode
        nameCurrency.text = currency.name
        value.text = currency.value
        nominal.text = "номинал: ${currency.nominal.toString()}"

    }
}
