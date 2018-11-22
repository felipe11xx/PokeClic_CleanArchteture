package com.example.felipefrazao.pokeclic.presenter.feature.listcards

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ListCardsPresenterImpl @Inject constructor(private val listCards: com.example.felipefrazao.pokeclic.domain.usecase.ListCards):
    ListCards.Presenter {

    private var listCardsView: ListCards.View? = null
    override fun getCards(setCode:String) {
        listCardsView?.showLoading()
        listCards.execute(setCode,ListCardsListener())
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

   private inner class ListCardsListener: DisposableObserver<CardDaoEntity>() {
       override fun onComplete() {

       }

       override fun onNext(value: CardDaoEntity) {
           listCardsView?.showCards(value.transform()?.cards!!)
           listCardsView?.hideLoading()
       }

       override fun onError(e: Throwable?) {
            listCardsView?.hideLoading()

       }

   }

}