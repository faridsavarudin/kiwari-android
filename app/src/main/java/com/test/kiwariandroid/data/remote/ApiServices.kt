package com.test.kiwariandroid.data.remote

import com.google.gson.GsonBuilder
import com.test.kiwariandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiServices {

    companion object {
        fun getClient(): ApiInterface {
            val okHttpLoggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG)
                okHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            else
                okHttpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

            val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(okHttpLoggingInterceptor)
                .build()

            val gson = GsonBuilder().create()

            val retrofit = retrofit2.Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.BASEURL)
                .build()
            val service: ApiInterface = retrofit.create(
                ApiInterface::class.java)

            return service
        }
    }
}