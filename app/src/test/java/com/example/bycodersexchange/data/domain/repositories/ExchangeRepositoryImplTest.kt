package com.example.bycodersexchange.data.domain.repositories

import com.example.bycodersexchange.data.domain.model.ExchangeResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ExchangeRepositoryImplTest {

    private val repository: ExchangeRepository = mockk()

    @Test
    fun `when call getExchange should be return success`() = runBlocking {
        val exchange = mockk<List<ExchangeResponse>>()

        coEvery {
            repository.getExchange()
        } returns Result.success(exchange)

        repository.getExchange()

        coVerify {
            repository.getExchange()
        }

        confirmVerified(exchange)
    }

    @Test
    fun `when call getExchange should be return fail`() = runBlocking {
        val exchange = mockk<Throwable>()

        coEvery {
            repository.getExchange()
        } returns Result.failure(exchange)


        repository.getExchange()

        coVerify {
            repository.getExchange()
        }

        confirmVerified(exchange)
    }
}