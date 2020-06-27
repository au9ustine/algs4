package com.github.t1anchen.algs4.v2.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.v2.graph.undirected.Graph
import kotlin.test.Test
import kotlin.test.assertEquals

open class GraphTest {
    val stream = In("/algs4-data/tinyG.txt")
    val g = Graph(stream)

    @Test
    fun testInit() {
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
    fun testMyString() {
        val actual = Graph.toString(g.V, g.E, g.adj)
        val expected = """V=13, E=13
            |0: [5, 1, 2, 6]
            |1: [0]
            |2: [0]
            |3: [4, 5]
            |4: [3, 6, 5]
            |5: [0, 4, 3]
            |6: [4, 0]
            |7: [8]
            |8: [7]
            |9: [12, 10, 11]
            |10: [9]
            |11: [12, 9]
            |12: [9, 11]""".trimMargin()
        assertEquals(expected, actual)
    }
}
