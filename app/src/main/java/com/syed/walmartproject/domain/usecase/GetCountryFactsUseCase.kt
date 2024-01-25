package com.syed.walmartproject.domain.usecase

import com.syed.walmartproject.domain.repository.CountryFactsRepository

class GetCountryFactsUseCase(private val repository: CountryFactsRepository) {
    suspend fun execute() = repository.getCountryFacts()
}