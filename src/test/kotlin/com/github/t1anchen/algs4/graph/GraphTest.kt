package com.github.t1anchen.algs4.graph

import kotlin.test.Test

class GraphTest {
    @Test
    fun initV() {
        val g = Graph(5)
        println(g.adj.toList())
    }
}
