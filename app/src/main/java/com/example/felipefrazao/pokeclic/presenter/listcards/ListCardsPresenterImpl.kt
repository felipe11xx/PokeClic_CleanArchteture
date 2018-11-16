package com.example.felipefrazao.pokeclic.presenter.listcards

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ListCardsPresenterImpl @Inject constructor(private val listCards: com.example.felipefrazao.pokeclic.domain.usecase.ListCards): ListCards.Presenter{

    private var listCardsView: ListCards.View? = null
    override fun getCards() {
        listCardsView?.showLoading()
        listCards.execute(ListCardsListener())
    }

    override fun onViewAttached(view: ListCards.View) {
        this.listCardsView = view
    }

    override fun onViewDetached() {
        this.listCardsView = null
    }

    override fun destroy() {
        listCards.dispose()
    }

   private inner class ListCardsListener: DisposableObserver<CardDao>() {
       override fun onComplete() {

       }

       override fun onNext(value: CardDao) {
           listCardsView?.showCards(value.cards)
           listCardsView?.hideLoading()
       }

       override fun onError(e: Throwable?) {
            listCardsView?.hideLoading()

       }

   }

}