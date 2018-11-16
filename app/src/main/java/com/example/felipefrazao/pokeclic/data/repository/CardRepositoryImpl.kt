package com.example.felipefrazao.pokeclic.data.repository

import com.example.felipefrazao.pokeclic.data.repository.retrofit.CardClient
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.repository.CardRepository
import io.reactivex.Observable
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val cardClient: CardClient) : CardRepository{

    override fun listCards(): Observable<CardDao> {
        return cardClient.listCards()
    }

    override fun getCard(id: String): Observable<CardDao> {
        return cardClient.getCard(id)

    }


}