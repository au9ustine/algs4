package com.github.t1anchen.algs4.v1.graph.cycle

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DirectedCycleTest {
    @Test
    fun testInit() {
        val stream = In("/algs4-data/tinyDG.txt")
        val g = Digraph(stream)
        val finder = DirectedCycle(g)
        assertTrue(finder.hasCycle())
        assertEquals("[3, 5, 4, 3]", finder.cycle().toList().toString())
    }
}
