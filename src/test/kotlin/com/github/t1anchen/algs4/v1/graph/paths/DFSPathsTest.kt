package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.Vertex
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DFSPathsTest {

    @Test
    fun hasPathTo() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val dfp = DFSPaths(g, Vertex(3, g.V))
        assertTrue(dfp.hasPathTo(Vertex(0, g.V)))
        assertFalse(dfp.hasPathTo(Vertex(7, g.V)))
    }

    @Test
    fun pathTo() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val dfp = DFSPaths(g, Vertex(0, g.V))
        val actual = dfp.pathTo(Vertex(3, g.V)).toString()
        val expected = "[0, 5, 4, 3]"
        assertEquals(expected, actual)
    }
}
