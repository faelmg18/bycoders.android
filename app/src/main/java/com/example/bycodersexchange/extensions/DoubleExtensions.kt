package com.example.bycodersexchange.extensions

import com.example.bycodersexchange.constatns.ByCodersConstants
import java.text.NumberFormat
import java.util.Locale

fun Double.formatDollarCurrency(): String {
    return NumberFormat.getCurrencyInstance(
        Locale(
            ByCodersConstants.Strings.LANGUAGE,
            ByCodersConstants.Strings.COUNTRY
        )
    ).format(this)
}