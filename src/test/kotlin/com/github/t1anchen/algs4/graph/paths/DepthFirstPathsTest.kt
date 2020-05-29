package com.github.t1anchen.algs4.graph.paths

import com.github.t1anchen.algs4.graph.Graph
import com.github.t1anchen.algs4.graph.Vertex
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DepthFirstPathsTest {

    @Test
    fun hasPathTo() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val dfp = DepthFirstPaths(g, Vertex(3, g.V.size))
        assertTrue(dfp.hasPathTo(Vertex(0, g.V.size)))
        assertFalse(dfp.hasPathTo(Vertex(7, g.V.size)))
    }

    @Test
    fun pathTo() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val dfp = DepthFirstPaths(g, Vertex(0, g.V.size))
        val actual = dfp.pathTo(Vertex(3, g.V.size)).toString()
        val expected = "[0, 5, 4, 3]"
        assertEquals(expected, actual)
    }
}
