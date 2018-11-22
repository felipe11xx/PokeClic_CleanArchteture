package com.example.felipefrazao.pokeclic.presenter.feature.getcard

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.usecase.GetCard
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class GetCardPresenterImpl @Inject constructor(private val getCard: GetCard):
    com.example.felipefrazao.pokeclic.presenter.feature.getcard.GetCard.Presenter {



    private var getCardView: com.example.felipefrazao.pokeclic.presenter.feature.getcard.GetCard.View? = null

    override fun onViewAttached(view: com.example.felipefrazao.pokeclic.presenter.feature.getcard.GetCard.View) {
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

    private fun fmtCardName(card: Card): String =
        card.name?.replace("-EX","")?.replace("ex","")!!


    private fun fmtMoreInfo(card: Card):String {
        val msg: String
        if (card.supertype.equals("Pokémon")) {
            msg = ("Esse Pokémon possui " + card.hp + " de HP e seu número da pokédex é "
                    + card.nationalPokedexNumber + ".")
        } else if (card.supertype.equals("Trainer")) {
            msg = card.text?.get(0)!!
        } else {
            msg = card.name!!
        }
        return msg
    }

    override fun onClicked(card: Card) {

        getCardView?.showMoreInfo(fmtMoreInfo(card),fmtCardName(card))
    }


    private inner class GetCardListener: DisposableObserver<CardDaoEntity>() {
        override fun onComplete() {

        }

        override fun onNext(value: CardDaoEntity?) {
            getCardView?.showCard(value!!.card?.transform()!!)
            getCardView?.hideLoading()

        }

        override fun onError(e: Throwable?) {
            getCardView?.hideLoading()
        }

    }

}