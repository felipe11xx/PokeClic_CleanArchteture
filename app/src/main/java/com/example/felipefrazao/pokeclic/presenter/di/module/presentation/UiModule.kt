package com.example.felipefrazao.pokeclic.presenter.di.module.presentation

import com.example.felipefrazao.pokeclic.presenter.getCard.CardActivity
import com.example.felipefrazao.pokeclic.presenter.listcards.ListCardsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): ListCardsActivity


    @ContributesAndroidInjector
    abstract fun contributeCardActivity(): CardActivity

}
