package com.github.t1anchen.algs4.graph.paths

import com.github.t1anchen.algs4.graph.Graph
import com.github.t1anchen.algs4.graph.Vertex
import com.github.t1anchen.algs4.utils.In
import org.junit.Test

import org.junit.Assert.*

class BreadthFirstPathsTest {

    @Test
    fun pathTo() {
        val stream = In("/algs4-data/tinyG.txt")
        val g = Graph(stream)
        val bfp = BreadthFirstPaths(g, Vertex(0, g.V.size))
        val actual = bfp.pathTo(Vertex(3, g.V.size)).toString()
        val expected = "[0, 5, 3]"
        assertEquals(expected, actual)
    }
}
