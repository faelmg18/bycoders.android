package com.example.bycodersexchange.ui.states

import com.example.bycodersexchange.model.Exchange

data class ExchangeUiState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val exchange: List<Exchange> = emptyList()
) : UiState {
    fun showLoading() = this.copy(isLoading = true)
    fun hidLoading() = this.copy(isLoading = false)
    fun setSuccess(exchange: List<Exchange>) = this.copy(exchange = exchange)
    fun isError(hasError: Boolean) = this.copy(hasError = hasError)
}
