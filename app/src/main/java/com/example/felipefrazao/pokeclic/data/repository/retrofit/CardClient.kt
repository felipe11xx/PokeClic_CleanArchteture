package com.example.felipefrazao.pokeclic.data.repository.retrofit

import com.example.felipefrazao.pokeclic.data.entity.CardDaoEntity
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Path
import retrofit2.http.Query

interface CardClient {

    @GET("cards")
    fun listCards(@Query("setCode")setCode:String) : Observable<CardDaoEntity>

    @GET("cards/{id}")
    fun getCard(@Path("id")id:String): Observable<CardDaoEntity>

}