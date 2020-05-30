package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals

class DigraphTest {
    @Test
    fun initGraph() {
        val stream = In("/algs4-data/tinyDG.txt")
        val g = Digraph(stream)
        val actual = g.toString()
        val expected = """13 vertices, 22 edges
        |0: 1 5
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
        assertEquals(expected, actual)

        val expectedInDegree = mapOf(
                0 to 2,
                1 to 1,
                2 to 2,
                3 to 2,
                4 to 3,
                5 to 2,
                6 to 2,
                8 to 1,
                9 to 3,
                10 to 1,
                11 to 1,
                12 to 2
        ).toSortedMap()
        val actualInDegree = g.inDegree.toSortedMap()
        assertEquals(expectedInDegree.toString(), actualInDegree.toString())
    }
}
