package com.example.bycodersexchange.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.bycodersexchange.R
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_10
import com.example.bycodersexchange.model.TopBarParams
import com.example.bycodersexchange.ui.theme.LightColorPalette

@Composable
fun ExchangeAppBar(topBarParams: TopBarParams) {
    val backgroundColor = LightColorPalette.primary
    val contentColor = Color.White
    val elevation = DP_10

    if (topBarParams.isShowBackButton) {
        run {
            TopAppBar(
                title = { Text(text = topBarParams.title) },
                navigationIcon = {
                    IconButton(onClick = {
                        topBarParams.onClick?.invoke()
                    }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            stringResource(R.string.exchange_backicon_conent_description)
                        )
                    }
                },
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                elevation = elevation
            )
        }
    } else {
        run {
            TopAppBar(
                title = { Text(text = topBarParams.title) },
                backgroundColor = backgroundColor,
                contentColor = contentColor,
                elevation = elevation
            )
        }
    }
}