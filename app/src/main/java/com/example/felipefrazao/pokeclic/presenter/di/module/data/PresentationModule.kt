package com.example.felipefrazao.pokeclic.presenter.di.module.data

import com.example.felipefrazao.pokeclic.presenter.getCard.GetCard
import com.example.felipefrazao.pokeclic.presenter.getCard.GetCardPresenterImpl
import com.example.felipefrazao.pokeclic.presenter.listcards.ListCards
import com.example.felipefrazao.pokeclic.presenter.listcards.ListCardsPresenterImpl
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