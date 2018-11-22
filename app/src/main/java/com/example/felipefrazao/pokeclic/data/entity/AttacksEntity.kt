package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Attacks


data class AttacksEntity (
    val cost: List<String>,
    val name: String,
    val text: String,
    val damage: String,
    val convertedEnergyCost: Int
)  : Transform<Attacks> {

    override fun transform(): Attacks {
        return Attacks(cost,name,text,damage,convertedEnergyCost)
    }

}
