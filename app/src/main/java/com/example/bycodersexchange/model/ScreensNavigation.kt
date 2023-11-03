package com.example.bycodersexchange.model


sealed class ScreensNavigation(val router: String) {
    object ExchangesScreen : ScreensNavigation(ScreenName.EXCHANGE.value)
    object ExchangesDetailScreen : ScreensNavigation(ScreenName.EXCHANGE_DETAIL.value)
}