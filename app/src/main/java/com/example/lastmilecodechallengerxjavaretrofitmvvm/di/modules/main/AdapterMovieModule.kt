package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main

import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.AdapterMovieList
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdapterMovieModule {
    @Provides
    fun bindAdapterMovieList():AdapterMovieList = AdapterMovieList()
}