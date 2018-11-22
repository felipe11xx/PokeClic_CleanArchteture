package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Weaknesses

class WeaknessesEntity (
    val type:String,
    val value:String
): Transform<Weaknesses>{
    override fun transform(): Weaknesses {
        return Weaknesses(type, String())
    }

}
