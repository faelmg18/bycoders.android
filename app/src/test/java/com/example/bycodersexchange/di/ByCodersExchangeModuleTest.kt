package com.example.bycodersexchange.di

import com.example.bycodersexchange.core.test.ApplicationTest
import com.example.bycodersexchange.data.domain.repositories.ExchangeRepository
import com.example.bycodersexchange.data.domain.usecase.ExchangeUseCase
import com.example.bycodersexchange.ui.viewmodel.ExchangeViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.ksp.generated.module
import org.koin.test.KoinTest
import org.koin.test.get
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertNotNull

@RunWith(RobolectricTestRunner::class)
@Config(application = ApplicationTest::class)
class ByCodersExchangeModuleTest : KoinTest {

    private val byuCodersExchangeModule = ByCodersExchangeModule()

    @Before
    fun setup() {
        loadKoinModules(listOf(byuCodersExchangeModule.module))
    }

    @Test
    fun `when get ExchangeRepository by DI should returns instance`() {
        val repository = get<ExchangeRepository>()
        assertNotNull(repository)
    }

    @Test
    fun `when get ExchangeUseCase by DI should returns instance`() {
        val useCase = get<ExchangeUseCase>()
        assertNotNull(useCase)
    }

    @Test
    fun `when get ExchangeViewModel by DI should returns instance`() {
        val viewModel = get<ExchangeViewModel>()
        assertNotNull(viewModel)
    }

    @After
    fun after() {
        unloadKoinModules(listOf(byuCodersExchangeModule.module))
    }
}