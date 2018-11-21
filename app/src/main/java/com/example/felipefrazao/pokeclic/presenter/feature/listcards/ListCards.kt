package com.example.felipefrazao.pokeclic.presenter.feature.listcards


import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView
import com.example.felipefrazao.pokeclic.presenter.intefaces.LoadableResolution


interface ListCards {

    interface Presenter : BasePresenter<View> {

        fun getCards(setCode:String)

    }

    interface View: BaseView<Any?>, LoadableResolution {

        fun showCards(cards: List<Card>)

    }
}