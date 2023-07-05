package com.nosort.hiltfirst

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoCurrencyViewModel @Inject constructor(
    private val cryptoCurrencyRepository: CryptoCurrencyRepository
) : androidx.lifecycle.ViewModel() {

    private val cryptoCurrencyEmitter = MutableLiveData<List<CryptoCurrency>>()
    val cryptoCurrency: LiveData<List<CryptoCurrency>> = cryptoCurrencyEmitter

    init {
        loadCryptoCurrency()
    }

    private fun loadCryptoCurrency() {
        cryptoCurrencyEmitter.value = cryptoCurrencyRepository.getAll()
    }

}