package com.example.cartrackapp.data.service

import android.util.Log
import com.example.cartrackapp.BuildConfig
import com.example.cartrackapp.data.model.DataUser
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CarTrackService {

    @GET("users")
    suspend fun getUsers(): Response<List<DataUser>>

    companion object {
        fun create(): CarTrackService {
            val retrofitBuilder = Retrofit.Builder()
            retrofitBuilder.apply {
                baseUrl(BuildConfig.BASE_URL)
                client(getHttpClient())
                addConverterFactory(GsonConverterFactory.create())
            }
            return retrofitBuilder.build().create(CarTrackService::class.java)
        }


        private fun getHttpClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
//                    .addQueryParameter("apikey", BuildConfig.API_KEY)
                    .build()

                val requestBuilder = original.newBuilder()
                    .url(url)
                Log.d("URL", url.toString())
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            return httpClient.build()
        }

    }
}