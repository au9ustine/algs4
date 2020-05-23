package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals

class ConnectedComponentTest {

    @Test
    fun testToString() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val cc = ConnectedComponent(g)
        val actual = cc.toString()
        val expected = """3 components
            |[0, 1, 2, 3, 4, 5, 6]
            |[7, 8]
            |[9, 10, 11, 12]""".trimMargin()
        assertEquals(expected, actual)

    }
}
