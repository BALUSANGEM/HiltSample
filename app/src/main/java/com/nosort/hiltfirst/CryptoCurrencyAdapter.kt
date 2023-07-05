package com.nosort.hiltfirst

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CryptoCurrencyAdapter(private val cryptoCurrencies : List<CryptoCurrency>): RecyclerView.Adapter<CryptoCurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.crypto_currency_list_item, parent,false))
    }

    override fun getItemCount() = cryptoCurrencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptoCurrencies[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(currency: CryptoCurrency) {
            Glide.with(itemView).load(currency.image).into(itemView.findViewById(R.id.cryptoImage))
            itemView.findViewById<TextView>(R.id.cryptoName).text = currency.name
        }
    }
}