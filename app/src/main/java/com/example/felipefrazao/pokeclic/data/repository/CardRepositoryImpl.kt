package com.example.felipefrazao.pokeclic.data.repository

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import com.example.felipefrazao.pokeclic.data.repository.retrofit.CardClient
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import com.example.felipefrazao.pokeclic.domain.repository.CardRepository
import io.reactivex.Observable
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val cardClient: CardClient) : CardRepository{

    override fun listCards(setCode:String): Observable<CardDaoEntity> {
        return cardClient.listCards(setCode)
    }

    override fun getCard(id: String): Observable<CardDaoEntity> {
        return cardClient.getCard(id)

    }


}