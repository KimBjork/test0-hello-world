package com.mainpackage

import java.io.*
import com.fasterxml.jackson.module.kotlin.*

class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val startTime = System.currentTimeMillis()
            val res = Response().createString(startTime)
            println(res)
        }
    }

    fun handler(output: OutputStream): Unit {
        val startTime = System.currentTimeMillis()
        val mapper = jacksonObjectMapper()
        val res = Response().createJson(startTime)

        mapper.writeValue(output, res)
    }

}