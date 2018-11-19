package com.example.felipefrazao.pokeclic.presenter.di.module.data

import com.example.felipefrazao.pokeclic.data.repository.retrofit.CardClient
import com.example.felipefrazao.pokeclic.data.commons.AppUtils
import com.example.felipefrazao.pokeclic.data.repository.retrofit.SetClient
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    fun providesCardClient(retrofit: Retrofit): CardClient = retrofit.create(
        CardClient::class.java)

    @Provides
    fun providesSetClient(retrofit: Retrofit): SetClient = retrofit.create(
        SetClient::class.java)

}