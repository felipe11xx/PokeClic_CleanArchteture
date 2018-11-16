package com.example.felipefrazao.pokeclic.presenter.shared

import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.example.felipefrazao.pokeclic.presenter.intefaces.BasePresenter
import com.example.felipefrazao.pokeclic.presenter.intefaces.BaseView


abstract class BaseActivity : AppCompatActivity(), BaseView<Any?> {

    abstract fun getPresenter(): BasePresenter<*>


    override fun showUnknownError() {
        showAlertWithMessage("Opss! Ocorreu um erro.")
    }

    override fun showConnectionProblemError() {
        showAlertWithMessage("Parece que você está sem internet! Por favor, verifique a sua conexão e tente novamente.")
    }


    override fun showServerError() {
        showAlertWithMessage("Desculpe, estamos enfrentando problemas técnicos. Por favor, tente novamente mais tarde.")
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter().destroy()
    }

    private fun showAlertWithMessage(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton("ok") { _, _ ->
            }.show()
    }


}