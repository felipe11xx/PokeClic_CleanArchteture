package com.example.felipefrazao.pokeclic.presenter.getCard

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.usecase.GetCard
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class GetCardPresenterImpl @Inject constructor(private val getCard: GetCard):com.example.felipefrazao.pokeclic.presenter.getCard.GetCard.Presenter {

    private var getCardView: com.example.felipefrazao.pokeclic.presenter.getCard.GetCard.View? = null

    override fun onViewAttached(view: com.example.felipefrazao.pokeclic.presenter.getCard.GetCard.View) {
       this.getCardView = view
    }

    override fun onViewDetached() {
       this.getCardView = null
    }

    override fun destroy() {
       getCard.dispose()
    }

    override fun getCard(id:String) {
        getCardView?.showLoading()
        getCard.execute(id,GetCardListener())

    }


    private inner class GetCardListener: DisposableObserver<CardDao>() {
        override fun onComplete() {

        }

        override fun onNext(value: CardDao?) {
            getCardView?.showCard(value!!.card)
            getCardView?.hideLoading()

        }

        override fun onError(e: Throwable?) {
            getCardView?.hideLoading()
        }

    }

}