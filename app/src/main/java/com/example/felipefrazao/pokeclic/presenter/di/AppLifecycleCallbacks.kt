package com.example.felipefrazao.pokeclic.presenter.di

import android.app.Application

interface AppLifecycleCallbacks {

  fun onCreate(application: Application)

  fun onTerminate(application: Application)
}