package com.example.bycodersexchange.ui.screens.exchange

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_LIST
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.components.ErrorScreen
import com.example.bycodersexchange.ui.components.ExchangeComponentItem
import com.example.bycodersexchange.ui.components.ExchangeList
import com.example.bycodersexchange.ui.states.ExchangeUiEvent
import com.example.bycodersexchange.ui.theme.LightColorPalette
import com.example.bycodersexchange.ui.viewmodel.ExchangeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ExchangesScreen(
    viewModel: ExchangeViewModel = koinViewModel(),
    onClickItem: (Exchange) -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is ExchangeUiEvent.NextScreen -> {
                    onClickItem(event.exchange)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.getExchange()
    }

    if (state.isLoading) {
        CreateLoadingProgress()
    } else if (state.hasError) {
        ShowError(viewModel)
    } else {
        ExchangeList(exchanges = state.exchange) { exchange ->
            viewModel.gotoExchangeDetail(exchange)
        }
    }
}

@Composable
private fun ShowError(viewModel: ExchangeViewModel) {
    ErrorScreen() {
        viewModel.getExchange()
    }
}

@Composable
fun CreateLoadingProgress() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = LightColorPalette.primary
        )
    }
}