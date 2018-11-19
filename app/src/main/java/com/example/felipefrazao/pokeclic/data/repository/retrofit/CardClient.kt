package com.example.felipefrazao.pokeclic.data.repository.retrofit

import com.example.felipefrazao.pokeclic.domain.model.CardDao
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Path

interface CardClient {

    @GET("cards?count=20")
    fun listCards() : Observable<CardDao>

    @GET("cards/{id}")
    fun getCard(@Path("id")id:String): Observable<CardDao>

}