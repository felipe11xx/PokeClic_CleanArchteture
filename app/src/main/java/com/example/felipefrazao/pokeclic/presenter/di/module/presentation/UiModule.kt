package com.example.felipefrazao.pokeclic.presenter.di.module.presentation

import com.example.felipefrazao.pokeclic.presenter.feature.getcard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCardsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeListCardsActivity(): ListCardsActivity


    @ContributesAndroidInjector
    abstract fun contributeCardActivity(): CardActivity



}
