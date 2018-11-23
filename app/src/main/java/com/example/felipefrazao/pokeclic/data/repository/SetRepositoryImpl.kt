package com.example.felipefrazao.pokeclic.data.repository

import com.example.felipefrazao.pokeclic.data.entity.SetDaoEntity
import com.example.felipefrazao.pokeclic.data.repository.retrofit.SetClient
import com.example.felipefrazao.pokeclic.domain.model.SetDao
import com.example.felipefrazao.pokeclic.domain.repository.SetRepository
import io.reactivex.Observable
import javax.inject.Inject

class SetRepositoryImpl @Inject constructor(private val setClient: SetClient): SetRepository {
    override fun listSets(): Observable<SetDaoEntity> {
        return setClient.listSets()
    }
}