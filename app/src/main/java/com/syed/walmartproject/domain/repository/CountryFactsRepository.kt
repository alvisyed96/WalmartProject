package com.syed.walmartproject.domain.repository

import com.syed.walmartproject.data.util.NetworkHelper
import kotlinx.coroutines.flow.Flow

interface CountryFactsRepository {
    suspend fun getCountryFacts(): Flow<NetworkHelper>
}