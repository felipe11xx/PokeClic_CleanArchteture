package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Set
import com.example.felipefrazao.pokeclic.domain.model.SetDao

data class SetDaoEntity(

    var sets : List<SetEntity>?,
    val set: SetEntity?
):Transform<SetDao> {
    override fun transform(): SetDao {
        return SetDao(sets?.map { it.transform() },set?.transform())
    }
    fun reversedSets(){
        sets = sets?.reversed()

    }

}