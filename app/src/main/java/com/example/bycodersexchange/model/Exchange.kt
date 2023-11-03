package com.example.bycodersexchange.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exchange(
    val dataOrderBookEnd: String? = null,
    val dataOrderBookStart: String? = null,
    val dataQuoteEnd: String? = null,
    val dataQuoteStart: String? = null,
    val dataSymbolsCount: Int? = null,
    val dataTradeEnd: String? = null,
    val dataTradeStart: String? = null,
    val exchangeId: String? = null,
    val metricId: List<String>? = null,
    val name: String? = null,
    val volumeOneDayUsd: Double? = null,
    val volumeOneHrsUsd: Double? = null,
    val volumeOneMthUsd: Double? = null,
    val website: String? = null
) : Parcelable