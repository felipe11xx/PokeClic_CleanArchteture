package com.example.felipefrazao.pokeclic.data.entity

import com.example.felipefrazao.pokeclic.data.entity.transform.Transform
import com.example.felipefrazao.pokeclic.domain.model.Card
import com.example.felipefrazao.pokeclic.domain.model.RetreatCost

data class CardEntity(
    val id: String?,
    val name: String?,
    var nationalPokedexNumber: Int?,
    val imageUrl: String?,
    val imageUrlHiRes: String?,
    val types: List<String>?,
    val supertype: String?,
    var subtype: String?,
    var evolvesFrom: String?,
    var ability: AbilityEntity?,
    var hp: String?,
    var retreatCost: List<String> = listOf(),
    val number: String?,
    val convertedRetreatCost: Int?,
    val artist: String?,
    val rarity: String?,
    val series: String?,
    val set: String?,
    val setCode: String?,
    val text: List<String>?,
    var attacks: List<AttacksEntity>,
    var weaknesses: List<WeaknessesEntity>?
):Transform<Card>  {
    override fun transform(): Card {


        return Card(
            id,
            name,
            nationalPokedexNumber,
            imageUrl,
            imageUrlHiRes,
            types,
            supertype,
            subtype,
            evolvesFrom,
            ability?.transform(),
            hp,
            retreatCost?.map { RetreatCost.valueOf(it.toUpperCase()) },
            number,
            convertedRetreatCost,
            artist,
            rarity,
            series,
            set,
            setCode,
            text,
            attacks?.map {  it.transform() },
            weaknesses?.map { it.transform() }


            )
    }

}