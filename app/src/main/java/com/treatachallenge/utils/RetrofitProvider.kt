package com.treatachallenge.utils

import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitProvider {
    private var retrofitProvider: RetrofitProvider? = null
    private var retrofit: Retrofit? = null

    fun getInstance(): RetrofitProvider? {
        return if (retrofitProvider != null) retrofitProvider else RetrofitProvider().also {
            retrofitProvider = it
        }
    }

    fun getRetrofit(): Retrofit? {
        return retrofit
    }

    fun provideRetrofit(url: String): Retrofit? {
        return if (retrofit != null) retrofit else createRetrofitInstance(url).also {
            retrofit = it
        }
    }

    private fun createRetrofitInstance(url: String): Retrofit {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}