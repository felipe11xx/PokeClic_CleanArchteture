package com.example.felipefrazao.pokeclic.domain.usecase

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.repository.CardRepository
import com.example.felipefrazao.pokeclic.domain.shared.PostExecutionThread
import com.example.felipefrazao.pokeclic.domain.shared.ThreadExecutor
import io.reactivex.Observable
import javax.inject.Inject

class GetCard @Inject constructor(
    private val cardRepository: CardRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCaseObservable.WithParam<CardDao, String>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: String): Observable<CardDao> {
        return cardRepository.getCard(params)
    }

}