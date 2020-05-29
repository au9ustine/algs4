package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals

class GraphTest {
    @Test
    fun initV() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val actual = g.toString()
        val expected = """13 vertices, 13 edges
        |0: 5 1 2 6
        |1: 0
        |2: 0
        |3: 4 5
        |4: 3 6 5
        |5: 0 4 3
        |6: 4 0
        |7: 8
        |8: 7
        |9: 12 10 11
        |10: 9
        |11: 12 9
        |12: 9 11""".trimMargin()
        assertEquals(expected, actual)
    }

    @Test
    fun deepCopy() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val gCopy = Graph(g)
        assertEquals(g.E, gCopy.E)
        assertEquals(g.V, gCopy.V)
        assertEquals(g.adj, gCopy.adj)
    }
}
