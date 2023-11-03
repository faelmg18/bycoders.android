package com.example.bycodersexchange.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.bycodersexchange.constatns.ByCodersConstants
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_LIST
import com.example.bycodersexchange.model.Exchange

@Composable
fun ExchangeList(exchanges: List<Exchange>, onClickItem: (Exchange) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(COMPOSE_TEST_TAG_EXCHANGE_LIST)
    ) {
        items(exchanges.size) {
            ExchangeComponentItem(exchange = exchanges[it]) { exchange ->
                onClickItem(exchange)
            }
        }
    }
}