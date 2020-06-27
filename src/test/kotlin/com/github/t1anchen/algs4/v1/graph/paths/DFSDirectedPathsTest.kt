package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex
import com.github.t1anchen.algs4.utils.In
import org.junit.Test

import org.junit.Assert.*

class DFSDirectedPathsTest {

    @Test
    fun pathTo() {
        val stream = In("/algs4-data/tinyDG.txt")
        val g = Digraph(stream)
        val s = Vertex(0, g.V)
        val t1 = Vertex(4, g.V)
        val t2 = Vertex(6, g.V)
        val path = DFSDirectedPaths(g, s)
        assertEquals("[0, 5, 4]", path.pathTo(t1).toString())
        //assertEquals("[]", path.pathTo(t2).toString())
    }
}
