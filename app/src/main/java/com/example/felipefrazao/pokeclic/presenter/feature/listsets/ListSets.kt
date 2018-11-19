package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import com.example.felipefrazao.pokeclic.domain.model.Set
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView
import com.example.felipefrazao.pokeclic.presenter.intefaces.LoadableResolution

interface ListSets {
    interface Presenter : BasePresenter<View>{
        fun listSets()
    }

    interface View : BaseView<Any?>, LoadableResolution{
        fun showSets(sets : List<Set>)
    }
}