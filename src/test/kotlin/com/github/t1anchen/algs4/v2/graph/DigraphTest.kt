package com.github.t1anchen.algs4.v2.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.v2.graph.directed.Digraph
import kotlin.test.Test
import kotlin.test.assertEquals

class DigraphTest {
    val stream = In("/algs4-data/tinyDG.txt")
    val g = Digraph(stream)
    val expected = """13 vertices, 22 edges
        |0: 1 5
        |1: 
        |2: 3 0
        |3: 2 5
        |4: 2 3
        |5: 4
        |6: 0 8 4 9
        |7: 9 6
        |8: 6
        |9: 10 11
        |10: 12
        |11: 12 4
        |12: 9""".trimMargin()

    @Test
    fun testInit() {
        val actual = g.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testCopy() {
        val gCopy = Digraph(g)
        val actual = gCopy.toString()
        assertEquals(expected, actual)
    }
}
