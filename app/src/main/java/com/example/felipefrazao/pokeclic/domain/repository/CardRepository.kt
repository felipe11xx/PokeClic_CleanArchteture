package com.example.felipefrazao.pokeclic.domain.repository

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import com.example.felipefrazao.pokeclic.domain.model.CardDao
import io.reactivex.Observable

interface CardRepository {

    fun listCards(setCode:String) : Observable<CardDaoEntity>

    fun getCard(id:String): Observable<CardDaoEntity>
}