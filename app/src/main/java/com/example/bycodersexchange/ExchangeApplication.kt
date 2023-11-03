package com.example.bycodersexchange

import android.app.Application
import com.example.bycodersexchange.di.ByCodersExchangeModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class ExchangeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                ByCodersExchangeModule().module
            )
        }
    }
}