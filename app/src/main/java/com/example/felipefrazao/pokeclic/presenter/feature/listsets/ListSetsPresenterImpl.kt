package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import android.widget.Toast
import com.example.felipefrazao.pokeclic.R
import com.example.felipefrazao.pokeclic.domain.model.SetDao
import com.example.felipefrazao.pokeclic.domain.usecase.ListSet
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ListSetsPresenterImpl @Inject constructor(private val listSets: ListSet):ListSets.Presenter {
    private var listSetsView : ListSets.View? = null

    override fun listSets() {
        listSetsView?.showLoading()
        listSets.execute(ListSetListener())
    }

    override fun onViewAttached(view: ListSets.View) {
        this.listSetsView = view
    }

    override fun onViewDetached() {
       this.listSetsView = null
    }

    override fun destroy() {
       listSets.dispose()
    }

    private inner class ListSetListener : DisposableObserver<SetDao>(){
        override fun onComplete() {

        }

        override fun onNext(value: SetDao?) {
            listSetsView?.showSets(value!!.sets)
            listSetsView?.hideLoading()
        }

        override fun onError(e: Throwable?) {
            //Toast.makeText(,R.string.falha.toString(),Toast.LENGTH_LONG).show()
            listSetsView?.hideLoading()
        }

    }
}