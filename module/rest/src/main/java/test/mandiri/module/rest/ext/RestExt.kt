package test.mandiri.module.rest.ext

import android.util.Log
import retrofit2.Response

suspend fun <T> restApi(call: suspend () -> Response<T>): Result<T> {
    val result = try {
        val result = call()
        if (result.isSuccessful) {
            Result.success(requireNotNull(result.body()))
        } else {
            throw ApiError(result)
        }
    }catch (e:Exception){
        Result.failure<T>(e)
    }
    return result;
}

class ApiError(private val response: Response<*>) :
    Throwable(response.message()) {
    init {
        Log.e("Api Failure", "Request from: ${response.raw().request.url}")
        Log.e("Api Failure", "Response : ${response.errorBody()?.string()}")
    }
}