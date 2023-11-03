package com.example.bycodersexchange.data.domain.model

import com.example.bycodersexchange.model.Exchange
import com.google.gson.annotations.SerializedName

data class ExchangeResponse(
    @SerializedName("data_orderbook_end")
    val dataOrderBookEnd: String? = null,
    @SerializedName("data_orderbook_start")
    val dataOrderBookStart: String? = null,
    @SerializedName("data_quote_end")
    val dataQuoteEnd: String? = null,
    @SerializedName("data_quote_start")
    val dataQuoteStart: String? = null,
    @SerializedName("data_symbols_count")
    val dataSymbolsCount: Int? = null,
    @SerializedName("data_trade_end")
    val dataTradeEnd: String? = null,
    @SerializedName("data_trade_start")
    val dataTradeStart: String? = null,
    @SerializedName("exchange_id")
    val exchangeId: String? = null,
    @SerializedName("metric_id")
    val metricId: List<String>? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("volume_1day_usd")
    val volumeOneDayUsd: Double? = null,
    @SerializedName("volume_1hrs_usd")
    val volumeOneHrsUsd: Double? = null,
    @SerializedName("volume_1mth_usd")
    val volumeOneMthUsd: Double? = null,
    @SerializedName("website")
    val website: String? = null,
)

fun List<ExchangeResponse>.toExchange() = map {
    Exchange(
        dataOrderBookEnd = it.dataOrderBookEnd,
        dataOrderBookStart = it.dataOrderBookStart,
        dataQuoteEnd = it.dataQuoteEnd,
        dataQuoteStart = it.dataQuoteStart,
        dataSymbolsCount = it.dataSymbolsCount,
        dataTradeEnd = it.dataTradeEnd,
        dataTradeStart = it.dataTradeStart,
        exchangeId = it.exchangeId,
        metricId = it.metricId,
        name = it.name,
        volumeOneDayUsd = it.volumeOneDayUsd,
        volumeOneHrsUsd = it.volumeOneHrsUsd,
        volumeOneMthUsd = it.volumeOneMthUsd,
        website = it.website

    )
}