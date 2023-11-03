package com.example.bycodersexchange.data.domain.usecase

import com.example.bycodersexchange.data.domain.model.Either
import com.example.bycodersexchange.data.domain.model.toExchange
import com.example.bycodersexchange.data.domain.repositories.ExchangeRepository
import com.example.bycodersexchange.extensions.toEither
import com.example.bycodersexchange.model.Exchange
import org.koin.core.annotation.Factory

@Factory
class ExchangeUseCase(private val repository: ExchangeRepository) :
    UseCase<List<Exchange>, Nothing>() {
    override suspend fun run(params: Nothing?): Either<Throwable, List<Exchange>> {
        val result = repository.getExchange()
        return result.toEither {
            it.toExchange()
        }
    }
}