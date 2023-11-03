package com.example.bycodersexchange.data.domain.repositories

import com.example.bycodersexchange.data.domain.model.ExchangeResponse

interface ExchangeRepository {
    suspend fun getExchange(): Result<List<ExchangeResponse>>
}