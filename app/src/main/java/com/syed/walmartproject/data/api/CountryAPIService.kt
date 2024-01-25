package com.syed.walmartproject.data.api

import com.syed.walmartproject.data.model.APIResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface CountryAPIService {

    @GET(APIDetails.ENDPOINT)
    suspend fun getCountryFacts(): Response<ArrayList<APIResponseItem>>
}