package com.syed.walmartproject.data.repository

import com.syed.walmartproject.data.api.CountryAPIService
import com.syed.walmartproject.data.util.NetworkHelper
import com.syed.walmartproject.domain.repository.CountryFactsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CountryFactsRepositoryImpl(val apiService: CountryAPIService) : CountryFactsRepository {
    override suspend fun getCountryFacts(): Flow<NetworkHelper> {
        return flow {
            try {
                emit(NetworkHelper.Loading)
                val response = apiService.getCountryFacts()
                if (response.isSuccessful && response.body() != null) {
                    emit(NetworkHelper.Success(response.body()!!))
                } else {
                    emit(NetworkHelper.Error(response.message()))
                }

            } catch (e: Exception) {
                emit(NetworkHelper.Error(e.message.toString()))
            }
        }
    }
}