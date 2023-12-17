package com.khantnyar.odoo_rest

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface OdooApiService  {
    @GET("api/{model_name}/search")
    suspend fun<T> search(
        @Path("model_name") modelName: String,
        @Query("domain") domain: String? = "[]",
        @Query("fields") fields: String = "[]",
        @Query("offset") offset: Int? = 0,
        @Query("limit") limit: Int? = null,
        @Query("order") order: String? = "name ASC",
    ): Call<BaseResponse<T>>

    @GET("api/{model_name}/{id}")
    suspend fun<T> getById(
        @Path("model_name") modelName: String,
        @Path("id") id: Int
    ): Call<BaseResponse<T>>

    @POST("api/{model_name}/create")
    suspend fun<T> create(
        @Path("model_name") modelName: String,
        @Body data: Any
    ): Call<BaseResponse<T>>

    @PUT("api/{model_name}/{id}")
    suspend fun<T> update(
        @Path("model_name") modelName: String,
        @Path("id") id: Int,
        @Body data: Any
    ): Call<BaseResponse<T>>

    @DELETE("api/{model_name}/{id}")
    suspend fun<T> delete(
        @Path("model_name") modelName: String,
        @Path("id") id: Int
    ): Call<BaseResponse<T>>

    @GET("api/{model_name}/schema")
    suspend fun<T> getSchema(@Path("model_name") modelName: String): Call<BaseResponse<T>>

    @POST("api/{model_name}/execute_kw")
    suspend fun<T> executeKw(
        @Path("model_name") modelName: String,
        @Body data: Any
    ): Call<BaseResponse<T>>

}



//    companion object {
//        private const val BASE_URL = "https://odoo.linklusion.co.jp/"
//        private const val API_KEY = "AKK3FNOAA9TDXO7PM2EF9VNKGWOICVS5"
//
//        // Create Logger
//        private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
//
//        // Create a Custom Interceptor to apply Headers application-wide
//        private val headerInterceptor = Interceptor { chain ->
//            var request = chain.request()
//            val url = request.url.newBuilder()
//                .addQueryParameter("api_key", API_KEY)
//                .build()
//            request = request.newBuilder().header("Cache-Control", "no-cache").url(url).build()
//            chain.proceed(request)
//        }
//
//        // Create OkHttp Client
//        private val okHttp = OkHttpClient.Builder()
//            .callTimeout(15, TimeUnit.MINUTES)
//            .connectTimeout(15, TimeUnit.MINUTES)
//            .writeTimeout(15, TimeUnit.MINUTES)
//            .readTimeout(15, TimeUnit.MINUTES)
//            .addInterceptor(headerInterceptor)
//            .addInterceptor(logger)
//            .build()
//
//        private val gson = GsonBuilder().setLenient().create()
//
//        private val retrofit: Retrofit by lazy {
//            Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(okHttp)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build()
//        }
//
//        val apiService: OdooApiService by lazy {
//            retrofit.create(OdooApiService::class.java)
//        }
//    }