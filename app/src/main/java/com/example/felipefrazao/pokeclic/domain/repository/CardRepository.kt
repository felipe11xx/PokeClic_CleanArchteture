package com.example.felipefrazao.pokeclic.domain.repository

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import io.reactivex.Observable

interface CardRepository {

    fun listCards() : Observable<CardDao>

    fun getCard(id:String): Observable<CardDao>
}