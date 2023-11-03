package com.example.bycodersexchange.data.domain.repositories

import com.example.bycodersexchange.data.remote.helper.doRequest
import com.example.bycodersexchange.data.domain.api.ExchangeApi
import com.example.bycodersexchange.data.domain.model.ExchangeResponse
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.annotation.Single

@Single
class ExchangeRepositoryImpl(
    private val api: ExchangeApi,
    private val dispatcher: CoroutineDispatcher
) :
    ExchangeRepository {
    override suspend fun getExchange(): Result<List<ExchangeResponse>> = doRequest(dispatcher) {
        api.getExchange().body()!!
    }
}