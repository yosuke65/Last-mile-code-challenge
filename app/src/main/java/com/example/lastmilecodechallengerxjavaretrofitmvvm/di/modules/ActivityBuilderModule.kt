package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules

import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main.AdapterMovieModule
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main.MainViewModelModule
import com.example.lastmilecodechallengerxjavaretrofitmvvm.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    //Activity level dependency
    @ContributesAndroidInjector(
        modules = [
        MainViewModelModule::class,
        AdapterMovieModule::class
        ]
    )
    abstract fun contributeMainActivity():MainActivity

}