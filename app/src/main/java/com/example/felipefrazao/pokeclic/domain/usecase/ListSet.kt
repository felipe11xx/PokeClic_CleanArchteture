package com.example.felipefrazao.pokeclic.domain.usecase

import com.example.felipefrazao.pokeclic.data.entity.SetDaoEntity
import com.example.felipefrazao.pokeclic.domain.model.SetDao
import com.example.felipefrazao.pokeclic.domain.repository.SetRepository
import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor
import io.reactivex.Observable
import javax.inject.Inject

class ListSet @Inject constructor(
    private val setRepository: SetRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCaseObservable.WithoutParam<SetDaoEntity>(threadExecutor,postExecutionThread){
    override fun buildUseCaseObservable(): Observable<SetDaoEntity> {
        return setRepository.listSets().map {
            it?.reversedSets()
            it
        }
    }

}