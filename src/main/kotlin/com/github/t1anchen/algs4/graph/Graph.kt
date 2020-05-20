package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.Bag
import com.github.t1anchen.algs4.utils.In

class Graph {
    val V: Int
    var E: Int = 0
    val adj: Array<Bag<Int>>

    constructor(V: Int) {
        if (V < 0)
            throw IllegalArgumentException("Number of vertices must be nonnegative")
        this.V = V
        adj = Array(V) { Bag<Int>() }
    }

    constructor(stream: In) {
        if (stream == null) throw IllegalArgumentException("argument is null")
        try {
            this.V = stream.readInt()
            if (V < 0) throw IllegalArgumentException("number of vertices in a Graph must be non-negative")
            adj = Array<Bag<Int>>(V) { Bag() }

            val E: Int = stream.readInt();
            if (E < 0) throw IllegalArgumentException("number of edges in a Graph must be non-negative")
            (0 until E).forEach {
                val v = stream.readInt()
                val w = stream.readInt()
                validateVertex(v)
                validateVertex(w)
                addEdge(v, w)
            }
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("invalid input format in Graph constructor", e)
        }
    }

    private fun validateVertex(v: Int) {
        if (v < 0 || v >= V)
            throw IllegalArgumentException("vertex $v is not between 0 and ${V - 1}")
    }

    fun addEdge(v: Int, w: Int) {
        validateVertex(v)
        validateVertex(w)
        E++;
        adj[v].add(w)
        adj[w].add(v)
    }

    fun adj(v: Int): Iterable<Int> {
        validateVertex(v)
        return adj[v]
    }

    fun degree(v: Int): Int {
        validateVertex(v)
        return adj[v].size()
    }

    override fun toString(): String {
        val lineSep = System.getProperty("line.separator")

        // [2020-05-19T21:56:48+0800] Here use "$v:$..." instead of "$v: $..." because somehow the latter adds one extra
        // space, which is not expected
        return "$V vertices, $E edges$lineSep" +
                adj.mapIndexed { v, adj_v ->
                    """$v:${adj_v.fold(
                            "", { acc, w -> "$acc $w" }
                    )}"""
                }.joinToString(lineSep)
    }

}
