package test.mandiri.application.ext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> useCase(call: suspend () -> T) = flow {
    emit(call())
}.flowOn(Dispatchers.IO)