package com.github.t1anchen.algs4.v1.graph.cc

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.cycle.Cycle
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CycleTest {
    @Test
    fun testInit() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val finder = Cycle(g)
        assertTrue(finder.hasCycle())
        assertEquals("[3, 4, 5, 3]", finder.cycle().toString())
    }
}
