package com.example.felipefrazao.pokeclic.presenter.shared

import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView

abstract class BaseFragment: Fragment(), BaseView<Any?> {

    override fun showServerError() {

    }

    override fun showConnectionProblemError() {

    }

    abstract fun getPresenter(): BasePresenter<*>


    override fun onDestroy() {
        super.onDestroy()
        getPresenter().destroy()
    }

    override fun onDestroyView() {
        getPresenter().onViewDetached()
        super.onDestroyView()
    }



}