package com.example.lastmilecodechallengerxjavaretrofitmvvm.base

import com.example.lastmilecodechallengerxjavaretrofitmvvm.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return  DaggerAppComponent.builder().application(this).build()
    }
}