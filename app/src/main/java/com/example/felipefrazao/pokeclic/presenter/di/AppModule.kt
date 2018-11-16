package com.example.felipefrazao.pokeclic.presenter.di

import android.content.Context
import br.com.ciclic.presentation.di.module.data.DataModule
import com.example.felipefrazao.pokeclic.data.executor.JobExecutor
import com.example.felipefrazao.pokeclic.presenter.di.module.data.RetrofitModule
import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor
import com.example.felipefrazao.pokeclic.presenter.di.module.data.PresentationModule
import com.example.felipefrazao.pokeclic.presenter.shared.thread.UIThread

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [(DataModule::class), (PresentationModule::class),(RetrofitModule::class)])
class AppModule(val context:Context)   {

    @Singleton
    @Provides
    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

    @Singleton
    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    fun provideContext():Context {
        return context
    }

}