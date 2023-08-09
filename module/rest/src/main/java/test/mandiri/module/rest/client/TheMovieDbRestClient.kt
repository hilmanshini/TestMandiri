package test.mandiri.module.rest.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Duration
import javax.inject.Named

class TheMovieDbRestClient(
    @Named("01a302300e7fbc9fb7f0af4e18399388")
    val apiKey: String,
    @Named("readTimeout")
    val readTimeout: Duration,
    @Named("writeTimeout")
    val writeTimeout: Duration,
    @Named("baseUrl")
    val baseUrl: String
) {

    private inner class HeaderAuthorizationInterceptor() : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            val authenticatedRequest: Request = request.newBuilder()
                .header("Authorization", "Bearer $apiKey").build()
            return chain.proceed(authenticatedRequest)
        }

    }

    private val api: Retrofit by lazy {
        val okHttp =
            OkHttpClient.Builder().addInterceptor(HeaderAuthorizationInterceptor()).addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.BODY
                )
            ).readTimeout(
                readTimeout
            ).writeTimeout(
                writeTimeout
            ).build()
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .baseUrl(baseUrl).build()
    }

    fun <T> create(clazz: Class<T>): T = api.create(clazz)
}