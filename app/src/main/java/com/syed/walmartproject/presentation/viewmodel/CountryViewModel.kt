package com.syed.walmartproject.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syed.walmartproject.data.util.NetworkHelper
import com.syed.walmartproject.domain.usecase.GetCountryFactsUseCase
import kotlinx.coroutines.launch

class CountryViewModel(private val getCountryFactsUseCase: GetCountryFactsUseCase) : ViewModel() {

    private val _countriesFact = MutableLiveData<NetworkHelper>()
    val countriesFact: LiveData<NetworkHelper> = _countriesFact

    fun getCountryFacts() = viewModelScope.launch {
        getCountryFactsUseCase.execute().collect {
            _countriesFact.postValue(it)
        }
    }
}