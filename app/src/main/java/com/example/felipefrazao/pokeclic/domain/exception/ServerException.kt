package com.example.felipefrazao.pokeclic.domain.exception

import java.lang.RuntimeException

class ServerException(val stattusCode: Int =0):RuntimeException()