package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main

import androidx.lifecycle.ViewModel
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.annotations.ViewModelKey
import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel):ViewModel
}