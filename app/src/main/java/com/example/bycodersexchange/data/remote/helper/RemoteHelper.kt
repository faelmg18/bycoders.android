package com.example.bycodersexchange.data.remote.helper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.Request

suspend fun <T> doRequest(
    ioDispatcher: CoroutineDispatcher,
    request: suspend CoroutineScope.() -> T
): Result<T> = withContext(ioDispatcher) {
    return@withContext try {
        Result.success(request())
    } catch (exception: Exception) {
        Result.failure(exception)
    }
}