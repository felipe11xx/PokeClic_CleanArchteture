package com.example.felipefrazao.pokeclic.data.repository.retrofit

import com.example.felipefrazao.pokeclic.domain.model.SetDao
import io.reactivex.Observable
import retrofit2.http.GET

interface SetClient {

    @GET("sets")
    fun listSets() : Observable<SetDao>
}