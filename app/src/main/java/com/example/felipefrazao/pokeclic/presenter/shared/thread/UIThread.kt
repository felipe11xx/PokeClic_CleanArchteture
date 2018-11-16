package com.example.felipefrazao.pokeclic.presenter.shared.thread


import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject
internal constructor() : PostExecutionThread {

    override fun scheduler(): Scheduler {
       return AndroidSchedulers.mainThread()
    }

}
