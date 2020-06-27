package com.github.t1anchen.algs4.v2.graph.directed

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.v2.graph.undirected.Graph
import java.lang.Exception

class Digraph {
    val V: Int
    var E: Int = 0
    val adj: Array<MutableList<Int>>
    val inDegree: Array<Int>

    constructor(V: Int) {
        Graph.assertNonNegativeVertices(V)
        this.V = V
        this.E = 0
        this.inDegree = Array(V) { 0 }
        this.adj = Array(V) { mutableListOf<Int>() }
    }

    constructor(stream: In) {
        try {
            this.V = stream.readInt()
            Graph.assertNonNegativeVertices(this.V)

            this.inDegree = Array(V) { 0 }

            this.adj = Array(V) { mutableListOf<Int>() }

            val E = stream.readInt()
            Graph.assertNonNegativeEdges(E)
            addEdges(E, stream)
        } catch (e: Exception) {
            throw IllegalArgumentException(
                    "invalid input format in Graph constructor",
                    e
            )
        }
    }

    constructor(G: Digraph) {
        this.V  = G.V
        Graph.assertNonNegativeVertices(this.V)
        this.E = G.E

        this.inDegree = Array(this.V) { G.inDegree[it] }

        this.adj = Array(this.V) { G.adj[it].toMutableList() } // Deep copy
    }

    fun addEdges(E: Int, stream: In) {
        (0 until E).forEach {
            val v = stream.readInt()
            val w = stream.readInt()
            addEdge(v, w)
        }
    }

    fun addEdge(v: Int, w: Int) {
        Graph.assertValidVertex(v, this.V)
        Graph.assertValidVertex(w, this.V)
        adj[v].add(w)
        inDegree[w]++
        E++
    }

    fun reverse(): Digraph {
        val reverse = Digraph(this.V)
        (0 until V).forEach { v ->
            adj[v].forEach { w ->
                reverse.addEdge(w, v)
            }
        }
        return reverse
    }

    override fun toString(): String =
            Graph.toAlgs4String(
                    this.V,
                    this.E,
                    this.adj
            )
}
