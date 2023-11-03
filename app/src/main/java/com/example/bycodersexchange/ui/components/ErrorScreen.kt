package com.example.bycodersexchange.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.bycodersexchange.R
import com.example.bycodersexchange.constatns.ByCodersConstants
import com.example.bycodersexchange.constatns.ByCodersConstants.Dimens.DP_16

@Composable
fun ErrorScreen(onClickTryAgain: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.oh_no),
            "backIcon",
            Modifier
                .width(ByCodersConstants.Dimens.DP_100)
                .height(ByCodersConstants.Dimens.DP_100)
        )
        Text(
            text = stringResource(R.string.error_description),
            modifier = Modifier.padding(top = DP_16)
        )
        TextButton(onClick = onClickTryAgain, modifier = Modifier.padding(top = DP_16)) {
            Text(text = stringResource(R.string.try_again))
        }
    }
}