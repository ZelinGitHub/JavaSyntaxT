package com.company.kotlin.highfun

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock

/*
参数可以是lambda
表示需要加锁的操作
 */
fun <T> Lock.withLock(action: () -> T): T {
    lock()
    try {
        return action()
    } finally {
        unlock()
    }
}

fun readFirstLineFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}