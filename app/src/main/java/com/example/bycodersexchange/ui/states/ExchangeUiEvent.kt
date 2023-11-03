package com.example.bycodersexchange.ui.states

import com.example.bycodersexchange.model.Exchange

sealed interface ExchangeUiEvent {
    data class NextScreen(val exchange: Exchange) : ExchangeUiEvent
}