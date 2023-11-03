package com.example.bycodersexchange.data.domain.usecase

import com.example.bycodersexchange.data.domain.model.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.reflect.Type

abstract class UseCase<out Type, in Params : Any?> where Type : Any? {
    abstract suspend fun run(params: Params?): Either<Throwable, Type>

    operator fun invoke(
        params: Params? = null,
        scope: CoroutineScope,
        onResult: (Either<Throwable, Type>) -> Unit
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }

            onResult(deferred.await())
        }
    }
}