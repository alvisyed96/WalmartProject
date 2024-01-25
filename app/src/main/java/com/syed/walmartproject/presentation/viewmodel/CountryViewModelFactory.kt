package com.syed.walmartproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syed.walmartproject.domain.usecase.GetCountryFactsUseCase

class CountryViewModelFactory(private val getCountryFactsUseCase: GetCountryFactsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountryViewModel(getCountryFactsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}