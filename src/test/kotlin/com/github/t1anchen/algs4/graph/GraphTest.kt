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
        |0: 6 2 1 5
        |1: 0
        |2: 0
        |3: 5 4
        |4: 5 6 3
        |5: 3 4 0
        |6: 0 4
        |7: 8
        |8: 7
        |9: 11 10 12
        |10: 9
        |11: 9 12
        |12: 11 9""".trimMargin()
        assertEquals(expected, actual)
    }
}
