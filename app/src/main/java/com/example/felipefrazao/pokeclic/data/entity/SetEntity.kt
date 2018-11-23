package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Set

data class SetEntity (
val code: String?,
val ptcgoCode: String?,
val name: String?,
val series: String?,
val totalCards : Int?,
val standardLegal: Boolean?,
val expandedLegal: Boolean?,
val releaseDate: String?,
val symbolUrl: String?,
val logoUrl: String?
):Transform<Set>{
    override fun transform(): Set {
        return Set(
            code,
            ptcgoCode,
            name,
            series,
            totalCards,
            standardLegal,
            expandedLegal,
            releaseDate,
            symbolUrl,
            logoUrl
        )
    }

}