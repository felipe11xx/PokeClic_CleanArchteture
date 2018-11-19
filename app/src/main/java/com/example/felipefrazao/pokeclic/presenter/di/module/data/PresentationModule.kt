package com.example.felipefrazao.pokeclic.presenter.di.module.data

import com.example.felipefrazao.pokeclic.presenter.feature.getcard.GetCard
import com.example.felipefrazao.pokeclic.presenter.feature.getcard.GetCardPresenterImpl
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCards
import com.example.felipefrazao.pokeclic.presenter.feature.listcards.ListCardsPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PresentationModule {

    @Provides
    fun providesListCardsPresenter(presenter: ListCardsPresenterImpl): ListCards.Presenter {
        return presenter
    }

    @Provides
    fun providesGetCardsPresenter(presenter: GetCardPresenterImpl): GetCard.Presenter {
        return presenter
    }

}