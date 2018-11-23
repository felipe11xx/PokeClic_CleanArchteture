package com.example.felipefrazao.pokeclic.presenter.feature.listsets

import com.example.felipefrazao.pokeclic.data.entity.SetDaoEntity
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

    private inner class ListSetListener : DisposableObserver<SetDaoEntity>(){
        override fun onComplete() {

        }

        override fun onNext(value: SetDaoEntity?) {
            listSetsView?.showSets(value?.transform()?.sets!!)
            listSetsView?.hideLoading()
        }

        override fun onError(e: Throwable?) {
            //Toast.makeText(,R.string.falha.toString(),Toast.LENGTH_LONG).show()
            listSetsView?.hideLoading()
        }

    }
}