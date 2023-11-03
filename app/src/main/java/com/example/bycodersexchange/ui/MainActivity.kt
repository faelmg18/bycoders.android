package com.example.bycodersexchange.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.bycodersexchange.ui.screens.bycoderscreen.MainByCodersScreen

const val EXCHANGE_ARG_KEY = "exchange_arg_key"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainByCodersScreen()
        }
    }
}