package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main

import com.example.lastmilecodechallengerxjavaretrofitmvvm.api.Endpoint
import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainRepositoryModule {
    @Provides
    @Singleton
    fun provideMainRepository(endpoint: Endpoint):MainRepository{
        return  MainRepository(endpoint)
    }
}