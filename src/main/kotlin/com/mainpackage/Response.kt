package com.mainpackage

import java.io.File

data class HandlerOutput(val startTime: Long,
                         val coldStart: Boolean)

class Response {
    fun createString(startTime : Long):String {
        return "{\"startTime\": ${startTime}, \"coldStart\": ${isColdStart()}}"
    }

    fun createJson(startTime: Long) : HandlerOutput{
        return HandlerOutput(startTime, isColdStart())
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