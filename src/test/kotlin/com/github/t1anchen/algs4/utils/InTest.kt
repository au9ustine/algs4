package com.github.t1anchen.algs4.utils

import kotlin.test.Test
import kotlin.test.assertTrue

class InTest {

    @Test
    fun readInt() {
        // [2020-05-18T23:58:14+0800] Note:
        // 1. The resource files must be hierarchically arranged in src/main/resources rather than src/main/resource
        // 2. getResource/getResourceAsSteam must start with "/" (aka absolute path)
        // 3. Do not get classLoader, it would be null
        // 4. src/test/resources is not necessary when testing in Intellij with gradle
        val tinyGStream = this.javaClass.getResourceAsStream("/algs4-data/tinyG.txt")?.buffered()
        val stream = In(tinyGStream)
        for (i in 0..10) {
            println(stream.readInt())
        }
    }
}
