package com.example.bycodersexchange.data.domain.model

sealed class Either<out L, out R> {
    data class Left<out L>(val a: L?) : Either<L, Nothing>()
    data class Right<out R>(val a: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun fold(fnL: (L?) -> Unit, fnR: (R) -> Unit): Any = when (this) {
        is Left -> fnL(a)
        is Right -> fnR(a)
    }
}

fun <L> left(a: L) = Either.Left(a)
fun <R> right(a: R) = Either.Right(a)
