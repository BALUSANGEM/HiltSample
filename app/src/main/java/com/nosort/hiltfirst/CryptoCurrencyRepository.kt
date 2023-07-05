package com.nosort.hiltfirst

interface CryptoCurrencyRepository {
    fun getAll() : List<CryptoCurrency>
}