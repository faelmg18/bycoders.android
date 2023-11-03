package com.example.bycodersexchange.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import com.example.bycodersexchange.R
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_16
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_60
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_8
import com.example.bycodersexchange.constatns.ByCodersConstants.Strings.COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_ITEM
import com.example.bycodersexchange.extensions.formatDate
import com.example.bycodersexchange.extensions.formatDollarCurrency
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.ui.theme.LightColorPalette

@Composable
fun ExchangeComponentItem(
    modifier: Modifier = Modifier,
    exchange: Exchange,
    onClickItem: (Exchange) -> Unit = {}
) {
    Card(
        modifier
            .testTag(COMPOSE_TEST_TAG_EXCHANGE_COMPONENT_ITEM)
            .padding(horizontal = DP_16, vertical = DP_16)
            .clickable {
                onClickItem(exchange)
            }
            .semantics(mergeDescendants = true) { },
        shape = RoundedCornerShape(DP_8),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column {
            CreateHeader(exchange) {
                onClickItem(exchange)
            }

            Row(Modifier.fillMaxWidth()) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = DP_16, bottom = DP_16)
                ) {
                    Image(
                        painterResource(R.drawable.bitcoin),
                        "backIcon",
                        Modifier
                            .width(DP_60)
                            .height(DP_60)
                    )
                    Column(
                        modifier = Modifier.padding(top = DP_8),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = exchange.name.orEmpty())
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(end = DP_16),
                    horizontalAlignment = Alignment.End,
                ) {
                    Row {
                        Column {
                            Text(
                                text = stringResource(id = R.string.exchange_data_order_Book_start).format(
                                    exchange.dataTradeStart?.formatDate()
                                )
                            )
                        }
                    }

                    Row(Modifier.padding(top = DP_16)) {
                        Column {
                            Text(
                                text = stringResource(id = R.string.exchange_value_one_day).format(
                                    exchange.volumeOneDayUsd?.formatDollarCurrency()
                                )
                            )
                        }

                    }
                }
            }
        }
    }
}

@Composable
private fun CreateHeader(exchange: Exchange, onClick: () -> Unit = {}) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = exchange.exchangeId.orEmpty())
        }

        Column {
            IconButton(onClick = onClick) {
                Icon(Icons.Filled.Info,
                    stringResource(R.string.exchange_buttoninfo_content_description), tint = LightColorPalette.primary)
            }
        }
    }
}

