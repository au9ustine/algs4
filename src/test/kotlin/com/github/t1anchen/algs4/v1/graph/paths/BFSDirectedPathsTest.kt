package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test
import kotlin.test.assertEquals

class BFSDirectedPathsTest {
    @Test
    fun testInit() {
        val stream = In("/algs4-data/tinyDG.txt")
        val g = Digraph(stream)
        val s = Vertex(0, g.V)
        val t1 = Vertex(4, g.V)
        val t2 = Vertex(6, g.V)
        val bfdp = BFSDirectedPaths(g, Vertex(0, g.V))
        assertEquals("[0, 5, 4]", bfdp.pathTo(t1).toString())
        assertEquals("[]", bfdp.pathTo(t2).toString())
    }
}
