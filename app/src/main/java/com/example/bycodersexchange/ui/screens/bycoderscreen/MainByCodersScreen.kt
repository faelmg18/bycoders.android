package com.example.bycodersexchange.ui.screens.bycoderscreen

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bycodersexchange.R
import com.example.bycodersexchange.extensions.navigate
import com.example.bycodersexchange.extensions.requiredArg
import com.example.bycodersexchange.model.Exchange
import com.example.bycodersexchange.model.ScreenName
import com.example.bycodersexchange.model.ScreensNavigation
import com.example.bycodersexchange.model.TopBarParams
import com.example.bycodersexchange.ui.EXCHANGE_ARG_KEY
import com.example.bycodersexchange.ui.components.ExchangeAppBar
import com.example.bycodersexchange.ui.screens.exchange.ExchangesScreen
import com.example.bycodersexchange.ui.screens.exchangedetail.ExchangeDetailScreen

@Composable
fun MainByCodersScreen(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val context = LocalContext.current

    val exchange: Exchange? =
        backStackEntry?.requiredArg(EXCHANGE_ARG_KEY)

    val currentDestination = backStackEntry?.destination
    val topBarParams =
        getTopBarTitle(currentDestination = currentDestination, navController, exchange, context)

    Scaffold(
        topBar = {
            ExchangeAppBar(topBarParams = topBarParams)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ScreensNavigation.ExchangesScreen.router,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(route = ScreensNavigation.ExchangesScreen.router) {
                ExchangesScreen() {
                    navController.navigate(
                        ScreensNavigation.ExchangesDetailScreen.router, EXCHANGE_ARG_KEY to it
                    )
                }
            }

            composable(route = ScreensNavigation.ExchangesDetailScreen.router) {
                val exchange: Exchange? =
                    navController.currentBackStackEntry?.requiredArg(EXCHANGE_ARG_KEY)
                exchange?.apply {
                    ExchangeDetailScreen(this)
                }
            }
        }
    }
}

private fun getTopBarTitle(
    currentDestination: NavDestination?,
    navHostController: NavHostController,
    exchange: Exchange?,
    context: Context
): TopBarParams {
    val topBarParams = TopBarParams()
    currentDestination?.let { destination ->
        when (destination.route) {
            ScreenName.EXCHANGE.value -> {
                topBarParams.title = context.getString(R.string.exchange)
                topBarParams.isShowBackButton = false
            }

            else -> {
                topBarParams.title = exchange?.name.orEmpty()
                topBarParams.isShowBackButton = true
                topBarParams.onClick = {
                    navHostController.popBackStack()
                }
            }
        }
    }
    return topBarParams
}