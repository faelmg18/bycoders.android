package com.example.bycodersexchange.data.domain.api

import com.example.bycodersexchange.BuildConfig
import com.example.bycodersexchange.constatns.EXCHANGES
import com.example.bycodersexchange.data.domain.model.ExchangeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ExchangeApi {

    @GET(EXCHANGES)
    @Headers(
        "Accept: application/json",
        "X-CoinAPI-Key: ${BuildConfig.API_KEY}"
    )
    suspend fun getExchange(): Response<List<ExchangeResponse>>
}