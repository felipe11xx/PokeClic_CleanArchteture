package com.example.felipefrazao.pokeclic.presenter.feature.getcard

import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView
import com.example.felipefrazao.pokeclic.presenter.intefaces.LoadableResolution

interface GetCard {

    interface Presenter: BasePresenter<View>{

        fun getCard(id:String)


        fun onClicked(card:Card)
    }

    interface View: BaseView<Any?>, LoadableResolution{
        fun showCard(card:Card)

        fun showMoreInfo(msg:String,cardNameFmt:String)
    }
}