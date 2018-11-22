package com.example.felipefrazao.pokeclic.domain.model

enum class RetreatCost{
    COLORLESS,WATER,FIRE,GRASS,DARK,PSYCHIC,STEEL,FAIRY,FIGHTING,DRAGON,THUNDER
}

class Card (
    val id: String?,
    val name: String?,
    var nationalPokedexNumber: Int?,
    val imageUrl: String?,
    val imageUrlHiRes: String?,
    var types: List<String>?,
    var supertype: String?,
    var subtype: String?,
    var evolvesFrom: String?,
    var ability: Ability?,
    var hp: String?,
    var retreatCost: List<RetreatCost>?,
    val number: String?,
    var convertedRetreatCost: Int?,
    val artist: String?,
    val rarity: String?,
    val series: String?,
    val set: String?,
    val setCod: String?,
    val text :List<String>?,
    var attacks: List<Attacks>?,
    var weaknesses: List<Weaknesses>?
)