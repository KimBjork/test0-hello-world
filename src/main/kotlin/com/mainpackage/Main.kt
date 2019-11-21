package com.mainpackage

import java.io.*
import com.fasterxml.jackson.module.kotlin.*
import java.time.LocalDateTime

data class HandlerOutput(val coldStart: String,
                         val start: String,
                         val end: String
                         )

class Main {
    val mapper = jacksonObjectMapper()

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            println("Start!")
            val start = LocalDateTime.now()
            val end = LocalDateTime.now()

            println("$start $end")
        }
    }

    fun handler(output: OutputStream): Unit {
        val start = LocalDateTime.now()
        val end = LocalDateTime.now()

        mapper.writeValue(output, HandlerOutput(isColdStart().toString(), "$start", "$end"))
    }

    private fun isColdStart(): Boolean{
        val fileName = "/tmp/out.txt"
        val file = File(fileName)

        if(file.exists()){
            return false;
        }
        File(fileName).createNewFile()
        return true;
    }
}