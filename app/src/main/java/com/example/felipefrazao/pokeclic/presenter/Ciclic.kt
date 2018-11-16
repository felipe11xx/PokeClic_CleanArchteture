package com.example.felipefrazao.pokeclic.presenter

import com.example.felipefrazao.pokeclic.presenter.di.AppLifecycleCallbacks
import com.example.felipefrazao.pokeclic.presenter.di.AppModule
import com.example.felipefrazao.pokeclic.presenter.di.applyAutoInjector
import com.example.felipefrazao.pokeclic.presenter.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

open class Ciclic : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .appModule(AppModule(this))
            .build()
    }

    @Inject
    lateinit var appLifecycleCallbacks: AppLifecycleCallbacks

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
        appLifecycleCallbacks.onCreate(this)
    }
}