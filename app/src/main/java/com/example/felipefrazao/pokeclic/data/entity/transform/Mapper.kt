package com.example.felipefrazao.pokeclic.data.entity.transform

interface Mapper<in S, out T> {
    fun mapper(map:S): T
}