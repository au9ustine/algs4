package com.github.t1anchen.algs4.v2.graph.undirected

import com.github.t1anchen.algs4.utils.Err
import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.utils.R
import java.lang.Exception

class Graph {
    val V: Int
    var E: Int = 0
    val adj: Array<MutableList<Int>>

    companion object {
        const val INFINITY = Int.MAX_VALUE
        fun assertNonNegativeVertices(V: Int) {
            if (V < 0)
                Err.nonNegative("Number of vertices")
        }

        fun assertNonNegativeEdges(E: Int) {
            if (E < 0)
                Err.nonNegative("Number of edges")
        }

        fun assertValidVertex(v: Int, upper: Int) {
            if (v < 0 || v >= upper)
                Err.between(v, 0, (upper-1))
        }

        fun toAlgs4String(V: Int, E: Int, adj: Array<MutableList<Int>>):
                String =
                listOf<String>(
                        "$V vertices, $E edges",
                        (0 until V).map { v ->
                            "$v: ${adj[v].joinToString(" ")}"
                        }.joinToString(R.newline())
                ).joinToString(R.newline())

        fun toString(V: Int, E: Int, adj: Array<MutableList<Int>>): String =
                listOf<String>(
                        "V=$V, E=$E",
                        (0 until V).joinToString(R.newline()) { v ->
                            "$v: ${adj[v]}"
                        }
                ).joinToString(R.newline())
    }

    constructor(V: Int) {
        this.V = V
        this.E = 0
        this.adj = Array(V) { mutableListOf<Int>() }
    }

    constructor(stream: In) {
        try {
            this.V = stream.readInt()
            assertNonNegativeVertices(this.V)

            this.adj = Array(V) { mutableListOf<Int>() }

            val E = stream.readInt()
            assertNonNegativeEdges(E)
            addEdges(E, stream)
        } catch (e: Exception) {
            throw IllegalArgumentException(
                    "invalid input format in Graph constructor",
                    e
            )
        }
    }

    constructor(G: Graph) {
        this.V = G.V
        this.E = G.E
        assertNonNegativeVertices(V)

        this.adj = Array(V) { mutableListOf<Int>() }

        shareAdj(G)
    }

    fun addEdges(E: Int, stream: In) {
        (0 until E).forEach {
            val v = stream.readInt()
            val w = stream.readInt()
            assertValidVertex(v, V)
            assertValidVertex(w, V)
            addEdge(v, w)
        }
    }

    fun addEdge(v: Int, w: Int) {
        assertValidVertex(v, V)
        assertValidVertex(w, V)
        E++
        adj[v].add(w)
        adj[w].add(v)
    }

    fun shareAdj(G: Graph) {
        (0 until G.V).forEach { v ->
            this.adj[v].addAll(G.adj[v])
        }
    }

    override fun toString(): String =
            toAlgs4String(
                    this.V,
                    this.E,
                    this.adj
            )
}
