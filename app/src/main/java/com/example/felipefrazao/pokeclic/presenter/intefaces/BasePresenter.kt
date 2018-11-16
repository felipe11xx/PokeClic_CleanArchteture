package com.example.felipefrazao.pokeclic.presenter.intefaces

import com.example.felipefrazao.pokeclic.domain.exception.NetworkException
import com.example.felipefrazao.pokeclic.domain.exception.ServerException
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor

interface BasePresenter<in T> where T: BaseView<Any?> {

    fun onViewAttached(view:T)

    fun onViewDetached()

    fun destroy()

    fun detecGenericErrors(exeception: Throwable,view: BaseView<Any?>?){
        when(exeception){
            is NetworkException -> view?.showConnectionProblemError()
            is ServerException -> view?.showServerError()
            else -> view?.showUnknownError()
        }

    }
}