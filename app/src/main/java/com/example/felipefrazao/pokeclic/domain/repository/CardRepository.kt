package com.example.felipefrazao.pokeclic.domain.repository

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import io.reactivex.Observable

interface CardRepository {

    fun listCards(setCode:String) : Observable<CardDao>

    fun getCard(id:String): Observable<CardDao>
}