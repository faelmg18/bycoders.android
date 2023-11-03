package com.example.bycodersexchange.data.domain.usecase

import com.example.bycodersexchange.data.domain.model.Either
import com.example.bycodersexchange.data.domain.model.ExchangeResponse
import com.example.bycodersexchange.data.domain.repositories.ExchangeRepository
import com.example.bycodersexchange.model.Exchange
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ExchangeUseCaseTest {

    private val exchangeResponse = listOf(
        ExchangeResponse(
            name = "Bitcoin"
        )
    )

    @Test
    fun `when call getExchange request should be return success data`() = runBlocking {
        val repository = mockk<ExchangeRepository>() {
            coEvery { getExchange() } returns Result.success(exchangeResponse)
        }

        val useCase = ExchangeUseCase(repository)

        val result: Either<Throwable, List<Exchange>> = useCase.run(null)

        assert(result.isRight)

    }

    @Test
    fun `when call getExchange request should be return failure`() = runBlocking {
        val repository = mockk<ExchangeRepository>() {
            coEvery { getExchange() } returns Result.failure(Throwable())
        }

        val useCase = ExchangeUseCase(repository)

        val result: Either<Throwable, List<Exchange>> = useCase.run(null)

        assert(result.isLeft)
    }
}