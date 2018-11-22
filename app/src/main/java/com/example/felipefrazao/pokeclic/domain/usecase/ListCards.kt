package com.example.felipefrazao.pokeclic.domain.usecase

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.repository.CardRepository
import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor
import io.reactivex.Observable
import javax.inject.Inject

class ListCards @Inject constructor(
    private val cardRepository: CardRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCaseObservable.WithParam<CardDaoEntity, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params:String): Observable<CardDaoEntity> {
        return cardRepository.listCards(params)
    }

}