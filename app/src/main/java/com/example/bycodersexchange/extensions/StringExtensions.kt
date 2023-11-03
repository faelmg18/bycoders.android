package com.example.bycodersexchange.extensions

import com.example.bycodersexchange.constatns.ByCodersConstants
import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDate(): String {
    val parser = SimpleDateFormat(ByCodersConstants.Strings.DATE_FORMAT_PARSER, Locale.getDefault())
    val formatter =
        SimpleDateFormat(ByCodersConstants.Strings.DATE_FORMAT_FORMATTER, Locale.getDefault())
    val output: String? = parser.parse(this)?.let { formatter.format(it) }
    return output.orEmpty()
}