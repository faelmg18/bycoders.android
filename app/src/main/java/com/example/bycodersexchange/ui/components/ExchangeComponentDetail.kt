package com.example.bycodersexchange.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import com.example.bycodersexchange.R
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_16
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_5
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_8
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_DETAIL
import com.example.bycodersexchange.extensions.formatDate
import com.example.bycodersexchange.extensions.formatDollarCurrency
import com.example.bycodersexchange.model.Exchange

@Composable
fun ExchangeComponentDetail(
    modifier: Modifier = Modifier,
    exchange: Exchange
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag(COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_DETAIL)
    ) {

        val values = listOf<String>(
            context.getString(R.string.exchange_id).format(exchange.exchangeId),
            context.getString(R.string.exchange_name).format(exchange.name),
            context.getString(R.string.exchange_data_order_Book_start)
                .format(exchange.dataOrderBookStart?.formatDate()),
            context.getString(R.string.exchange_data_order_Book_end)
                .format(exchange.dataOrderBookEnd?.formatDate()),
            context.getString(R.string.exchange_data_quote_start)
                .format(exchange.dataQuoteStart?.formatDate()),
            context.getString(R.string.exchange_data_quote_end)
                .format(exchange.dataQuoteEnd?.formatDate()),
            context.getString(R.string.exchange_data_trade_start)
                .format(exchange.dataTradeStart?.formatDate()),
            context.getString(R.string.exchange_data_trade_end)
                .format(exchange.dataTradeEnd?.formatDate()),
            context.getString(R.string.exchange_data_symbols_count)
                .format(exchange.dataSymbolsCount),
            context.getString(R.string.exchange_volume_one_hrs_usd)
                .format(exchange.volumeOneHrsUsd?.formatDollarCurrency()),
            context.getString(R.string.exchange_value_one_day)
                .format(exchange.volumeOneDayUsd?.formatDollarCurrency()),
            context.getString(R.string.exchange_volume_one_mth_usd)
                .format(exchange.volumeOneMthUsd?.formatDollarCurrency()),
            context.getString(R.string.exchange_website).format(exchange.website),
        )

        items(values.size) {
            LabelExchangeDetail(values[it])
        }
    }
}

@Composable
private fun LabelExchangeDetail(itemLabel: String?, modifier: Modifier = Modifier) {
    Card(
        modifier
            .padding(horizontal = DP_16, vertical = DP_5)
            .fillMaxWidth()
            .semantics(mergeDescendants = true) { },
        shape = RoundedCornerShape(DP_8),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Text(modifier = Modifier.padding(DP_16), text = itemLabel.orEmpty())
    }
}

