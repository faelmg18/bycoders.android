package com.example.bycodersexchange.ui.viewmodel

import com.example.bycodersexchange.core.test.ApplicationTest
import com.example.bycodersexchange.core.test.MainDispatchRule
import com.example.bycodersexchange.data.domain.model.Either
import com.example.bycodersexchange.data.domain.model.ExchangeResponse
import com.example.bycodersexchange.data.domain.usecase.ExchangeUseCase
import com.example.bycodersexchange.di.ByCodersExchangeModule
import com.example.bycodersexchange.ui.states.ExchangeUiEvent
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
@Config(application = ApplicationTest::class)
class ExchangeViewModelTest : KoinTest {

    @get:Rule
    val mainDispatchRule = MainDispatchRule()
    private val byCodersExchangeModule = ByCodersExchangeModule()

    private val exchangeResponse = listOf(ExchangeResponse(name = "Bitcoin"))

    @Test
    fun `when call getExchange should be uiState not null or empty`() = runTest {

        val useCase = mockUseCaseWithSuccess()

        val viewModel: ExchangeViewModel = ExchangeViewModel(useCase)

        viewModel.getExchange()

        assert(viewModel.uiState.value.exchange.isNotEmpty())
    }


    @Test
    fun `when call getExchange should be result is ExchangeUiEvent ShowError`() = runBlocking {

        val useCase = mockUseCaseWithError()

        val viewModel: ExchangeViewModel = ExchangeViewModel(useCase)

        viewModel.getExchange()

        assert(viewModel.uiState.value.hasError)

    }

    @Test
    fun `when call getExchange should be uiState is empty`() = runBlocking {

        val useCase = mockUseCaseWithError()

        val viewModel: ExchangeViewModel = ExchangeViewModel(useCase)

        viewModel.getExchange()

        assert(viewModel.uiState.value.exchange.isEmpty())

    }

    private fun mockUseCaseWithSuccess(): ExchangeUseCase {
        val useCase = mockk<ExchangeUseCase>()
        coEvery {
            useCase(null, any(), any())
        } coAnswers {
            val callback = thirdArg<(Either<Throwable, List<ExchangeResponse>>) -> Unit>()
            callback(Either.Right(exchangeResponse))
        }

        return useCase
    }

    private fun mockUseCaseWithError(): ExchangeUseCase {
        val useCase = mockk<ExchangeUseCase>()
        coEvery {
            useCase(null, any(), any())
        } coAnswers {
            val callback = thirdArg<(Either<Throwable, List<ExchangeResponse>>) -> Unit>()
            callback(Either.Left(Throwable()))
        }

        return useCase
    }
}