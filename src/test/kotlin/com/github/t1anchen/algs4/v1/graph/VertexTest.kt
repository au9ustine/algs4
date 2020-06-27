package com.github.t1anchen.algs4.v1.graph

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class VertexTest {

    @Test
    fun compare() {
        val a = Vertex(1, 10)
        val b = Vertex(1, 10)
        assertEquals(a, b)
        val ctx: MutableMap<Vertex, MutableList<Vertex>> = mutableMapOf()
        ctx.put(a, mutableListOf(b))
        ctx.putIfAbsent(b, mutableListOf(a))
        assertEquals(1, ctx.size)
    }
}
