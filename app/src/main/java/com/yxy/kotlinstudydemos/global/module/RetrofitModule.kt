package com.ylpw.ticketapp.global.module

import com.ylpw.ticketapp.global.C
import com.yxy.kotlinstudydemos.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module class RetrofitModule {

    @Provides @Singleton fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        return builder.build()
    }

    @Provides @Singleton fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(C.api.BASE_SERVER_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}