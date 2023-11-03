package com.example.bycodersexchange.ui.screens.exchangedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.components.ExchangeComponentDetail

@Composable
fun ExchangeDetailScreen(exchange: Exchange) {
    Column {
        ExchangeComponentDetail(exchange = exchange)
    }
}