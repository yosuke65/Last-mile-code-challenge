package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.MainViewModel
import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.MainViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindMainViewModelProviderFactory(mainViewModelProviderFactory: MainViewModelProviderFactory): ViewModelProvider.Factory
}