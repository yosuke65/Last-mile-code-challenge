package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.api

import com.example.lastmilecodechallengerxjavaretrofitmvvm.api.Endpoint
import com.example.lastmilecodechallengerxjavaretrofitmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideEndpoint(retrofit: Retrofit):Endpoint{
        return retrofit.create(Endpoint::class.java)
    }
}