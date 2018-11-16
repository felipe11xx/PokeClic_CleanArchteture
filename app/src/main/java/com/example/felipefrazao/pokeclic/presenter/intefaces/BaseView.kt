package com.example.felipefrazao.pokeclic.presenter.intefaces

import com.example.felipefrazao.pokeclic.presenter.di.Injectable

interface BaseView<T> :Injectable {

    fun showUnknownError()

    fun showServerError()

    fun showConnectionProblemError()

}