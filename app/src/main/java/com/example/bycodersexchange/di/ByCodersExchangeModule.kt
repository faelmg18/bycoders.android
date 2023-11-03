package com.example.bycodersexchange.di

import com.example.bycodersexchange.data.domain.api.ExchangeApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.GlobalContext.get
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@ComponentScan("com.example.bycodersexchange")
class ByCodersExchangeModule {
    @Single
    fun retrofit() = getRetrofitInstance()

    @Single
    fun exchangeApi(): ExchangeApi = get().get<Retrofit>().create(ExchangeApi::class.java)

    @Single
    fun dispatchers(): CoroutineDispatcher = Dispatchers.IO
}

fun getRetrofitInstance(): Retrofit = Retrofit.Builder()
    .baseUrl("https://rest.coinapi.io/v1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

