package sk.mholecy.meteorites.meteorites.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(
    private val apiKey: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestBuilder = original.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("X-App-Token", apiKey)
            .method(original.method(), original.body())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}
