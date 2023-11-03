package com.example.bycodersexchange.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bycodersexchange.data.domain.repositories.ExchangeRepository
import com.example.bycodersexchange.data.domain.usecase.ExchangeUseCase
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.states.ExchangeUiEvent
import com.example.bycodersexchange.ui.states.ExchangeUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ExchangeViewModel(private val exchangeUseCase: ExchangeUseCase) : ViewModel() {
    private val _uiEvent = Channel<ExchangeUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _uiState = MutableStateFlow<ExchangeUiState>(ExchangeUiState())
    val uiState = _uiState.asStateFlow()

    fun getExchange() {
        _uiState.update { it.showLoading() }
        exchangeUseCase(scope = viewModelScope) {
            it.fold({
                _uiState.update { it.hidLoading().isError(true) }

            }) { exchanges ->
                _uiState.update { it.hidLoading().isError(false) }
                _uiState.update { it.setSuccess(exchanges) }
            }
        }
    }

    fun gotoExchangeDetail(exchange: Exchange) {
        emitEvent(ExchangeUiEvent.NextScreen(exchange))
    }

    private fun emitEvent(event: ExchangeUiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}