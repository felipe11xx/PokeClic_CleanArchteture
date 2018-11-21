package com.example.felipefrazao.pokeclic.presenter.di.module.presentation

import com.example.felipefrazao.pokeclic.presenter.feature.getcard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCardsActivity
import com.example.felipefrazao.pokeclic.presenter.feature.listsets.ListSetsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeListCardsActivity(): ListCardsActivity


    @ContributesAndroidInjector
    abstract fun contributeCardActivity(): CardActivity

    @ContributesAndroidInjector
    abstract  fun contributeListSetsActivity(): ListSetsActivity

}
