package com.example.felipefrazao.pokeclic.domain.repository

import com.example.felipefrazao.pokeclic.domain.model.SetDao
import io.reactivex.Observable

interface SetRepository {

    fun listSets(): Observable<SetDao>
}