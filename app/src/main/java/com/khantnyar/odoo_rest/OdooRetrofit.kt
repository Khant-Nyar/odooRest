package com.khantnyar.odoo_rest

import com.google.gson.GsonBuilder
import com.khantnyar.odoo_rest.OdooRetrofit.apiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object OdooRetrofit {
    private const val BASE_URL = "https://odoo.linklusion.co.jp/"
    private const val API_KEY = "AKK3FNOAA9TDXO7PM2EF9VNKGWOICVS5"
    // Create Logger
    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    // Create a Custom Interceptor to apply Headers application-wide
    private val headerInterceptor = Interceptor { chain ->
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()
        request = request.newBuilder().header("Cache-Control", "no-cache").url(url).build()
        chain.proceed(request)
    }

    // Create OkHttp Client
    private val okHttp = OkHttpClient.Builder()
        .callTimeout(15, TimeUnit.MINUTES)
        .connectTimeout(15, TimeUnit.MINUTES)
        .writeTimeout(15, TimeUnit.MINUTES)
        .readTimeout(15, TimeUnit.MINUTES)
        .addInterceptor(headerInterceptor)
        .addInterceptor(logger)
        .build()

    private val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService: OdooApiService by lazy {
        retrofit.create(OdooApiService::class.java)
    }
}


//object OdooApiHelper {
//
//    private const val DEFAULT_DOMAIN = "[]"
//    private const val DEFAULT_FIELDS = "[]"
//    private const val DEFAULT_ORDER = ""
//
//    suspend fun <T> search(
//        modelName: String,
//        domain: String = DEFAULT_DOMAIN,
//        fields: String = DEFAULT_FIELDS,
//        offset: Int? = 0,
//        limit: Int? = null,
//        order: String? = DEFAULT_ORDER
//    ): List<T>? {
//        return executeCall { apiService.search(modelName, domain, fields, offset, limit, order) }
//    }
//
//    suspend fun <T> getById(modelName: String, id: Int): T? {
//        return executeCall { apiService.getById(modelName, id) }
//    }
//
//    suspend fun <T> create(modelName: String, data: Any): T? {
//        return executeCall { apiService.create(modelName, data) }
//    }
//
//    suspend fun <T> update(modelName: String, id: Int, data: Any): T? {
//        return executeCall { apiService.update(modelName, id, data) }
//    }
//
//    suspend fun <T> delete(modelName: String, id: Int): T? {
//        return executeCall { apiService.delete(modelName, id) }
//    }
//
//    suspend fun <T> getSchema(modelName: String): T? {
//        return executeCall { apiService.getSchema(modelName) }
//    }
//
//    suspend fun <T> executeKw(modelName: String, data: Any): T? {
//        return executeCall { apiService.executeKw(modelName, data) }
//    }
//
//    private suspend fun <T> executeCall(apiCall: suspend () -> Call<BaseResponse<T>>): T? {
//        return try {
//            val response = apiCall.invoke().execute()
//            if (response.isSuccessful) {
//                response.body()?.data?.firstOrNull()
//            } else {
//                null
//            }
//        } catch (e: Exception) {
//            null
//        }
//    }
//}
