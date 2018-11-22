package com.example.felipefrazao.pokeclic.data.entity.transform

interface Transform<out T> {
    fun transform(): T
}