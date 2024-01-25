package com.syed.walmartproject.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIDetails {

    const val BASE_URL = "https://gist.githubusercontent.com/peymano-wmt/"

    const val ENDPOINT =
        "32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json"

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder().addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: CountryAPIService = retrofit.create(CountryAPIService::class.java)
}