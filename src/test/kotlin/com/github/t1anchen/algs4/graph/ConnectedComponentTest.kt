package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test

class ConnectedComponentTest {

    @Test
    fun testToString() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val cc = ConnectedComponent(g)
        println(cc.toString())
    }
}
