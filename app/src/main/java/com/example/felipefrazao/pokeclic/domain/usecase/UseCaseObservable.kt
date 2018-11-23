package com.example.felipefrazao.pokeclic.domain.usecase

import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor
import com.example.felipefrazao.pokeclic.presenter.feature.listsets.ListSetsPresenterImpl
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by viniciusmo on 9/5/17.
 */
abstract class UseCaseObservable {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }


    abstract class WithoutParam<T> constructor(private val threadExecutor: ThreadExecutor
                                               ,
                                               private val postExecutionThread: PostExecutionThread
    ) : UseCaseObservable() {

        internal abstract fun buildUseCaseObservable(): Observable<T>

        fun execute(observer: DisposableObserver<T>) {
            val observable = this.buildUseCaseObservable()
                    .subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.scheduler())
            addDisposable(observable.subscribeWith(observer))
        }

    }

    abstract class WithParam<T, in Params>
    internal constructor(val threadExecutor: ThreadExecutor,
                         val postExecutionThread: PostExecutionThread) : UseCaseObservable() {


        internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

        fun execute(params: Params,observer: DisposableObserver<T>) {
            val observable = this.buildUseCaseObservable(params)
                    .subscribeOn(Schedulers.from(threadExecutor))
                    .observeOn(postExecutionThread.scheduler())
            addDisposable(observable.subscribeWith(observer))
        }

    }
}