package com.example.bycodersexchange.core.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import com.example.bycodersexchange.ui.MainActivity
import org.junit.rules.TestRule

fun <R : TestRule, A : MainActivity> AndroidComposeTestRule<R, A>.setContentOnActivity(
    content: @Composable (MainActivity) -> Unit
) {
    this.activity.runOnUiThread {
        this.activity.setContent {
            content(activity)
        }
    }
}