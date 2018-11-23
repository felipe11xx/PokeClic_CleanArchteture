package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.CardDao

class CardDaoEntity (
    var cards: List<CardEntity>?,
    var card: CardEntity?
):Transform<CardDao>{
    override fun transform(): CardDao {
        return CardDao(cards?.map { it.transform() }?.sortedBy { it.number?.toDoubleOrNull() }
            ,card?.transform())
    }

}
