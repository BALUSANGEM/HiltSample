package com.nosort.hiltfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var cryptoCurrencyList: RecyclerView

    private lateinit var cryptoCurrencyViewModel: CryptoCurrencyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cryptoCurrencyList = findViewById(R.id.cryptocurrency_list)
        cryptoCurrencyList.layoutManager = LinearLayoutManager(this)

        cryptoCurrencyViewModel =
            ViewModelProvider(this)[CryptoCurrencyViewModel::class.java]

        loadCryptoCurrencies()
    }

    private fun loadCryptoCurrencies() {
        cryptoCurrencyViewModel.cryptoCurrency.observe(this) {
            cryptoCurrencyList.adapter = CryptoCurrencyAdapter(it)
        }
    }

}