package test.mandiri.application.ext

fun <T, R> Result<T>.then(map: (T) -> Result<R>): Result<R> {
    return if (isSuccess) {
        map(getOrThrow())
    } else {
        Result.failure(requireNotNull(exceptionOrNull()))
    }
}

fun <T, R> Result<List<T>>.mapResultList(transform: (T) -> R): Result<List<R>> {
    return if (isSuccess) {
        Result.success(getOrThrow().map(transform))
    } else {
        Result.failure(requireNotNull(exceptionOrNull()))
    }
}


