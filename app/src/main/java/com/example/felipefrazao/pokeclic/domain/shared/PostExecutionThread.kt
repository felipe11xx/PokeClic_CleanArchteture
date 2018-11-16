package com.example.felipefrazao.pokeclic.domain.shared

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun scheduler () : Scheduler
}
