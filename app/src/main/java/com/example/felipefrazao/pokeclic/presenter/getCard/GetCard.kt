package com.example.felipefrazao.pokeclic.presenter.getCard

import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView
import com.example.felipefrazao.pokeclic.presenter.intefaces.LoadableResolution

interface GetCard {

    interface Presenter: BasePresenter<View>{
        fun getCard(id:String)
    }

    interface View: BaseView<Any?>, LoadableResolution{
        fun showCard(card:Card)

        fun moreInfo(card: Card)
    }
}