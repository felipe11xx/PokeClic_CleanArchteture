package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Ability

class AbilityEntity (
    val name : String,
    val text : String,
    val type : String
): Transform<Ability>{
    override fun transform(): Ability {
        return Ability(name,text,type)
    }

}
