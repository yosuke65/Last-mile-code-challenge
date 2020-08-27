package com.example.lastmilecodechallengerxjavaretrofitmvvm.di.components

import android.app.Application
import com.example.lastmilecodechallengerxjavaretrofitmvvm.base.BaseApplication
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.ActivityBuilderModule
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.ViewModelFactoryModule
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.api.ApiModule
import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.modules.main.MainRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    //Application level dependency
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ApiModule::class,
        MainRepositoryModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}