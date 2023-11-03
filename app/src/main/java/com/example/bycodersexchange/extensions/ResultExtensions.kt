package com.example.bycodersexchange.extensions

import com.example.bycodersexchange.data.domain.model.Either

fun <T, Type> Result<T>.toEither(mapper: (T) -> Type): Either<Throwable, Type> {
    return if (isSuccess) {
        val data = mapper(this.getOrThrow())
        Either.Right(data)
    } else {
        Either.Left(this.exceptionOrNull())
    }
}