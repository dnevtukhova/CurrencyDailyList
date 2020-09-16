package com.example.dnevtukhova.currencydailylist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dnevtukhova.currencydailylist.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragmentContainer,
                CurrencyListFragment(),
                CurrencyListFragment.TAG
            )
            .commit()
    }
}