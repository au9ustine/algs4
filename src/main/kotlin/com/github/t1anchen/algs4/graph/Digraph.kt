package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.utils.R
import java.lang.IllegalArgumentException

class Digraph {
    val V: MutableList<Vertex> = mutableListOf()
    var E: Int = 0
    val adj: MutableMap<Vertex, MutableList<Vertex>> = mutableMapOf()
    val inDegree: MutableMap<Vertex, Int> = mutableMapOf()

    constructor(V: Int) {
        if (V < 0)
            throw IllegalArgumentException("Number of vertices in a Digraph must be nonnegative")
        (0 until V).forEach { this.V.add(Vertex(it, V)) }
    }

    constructor(stream: In) {
        try {
            val totalV = stream.readInt()
            if (totalV < 0) throw IllegalArgumentException(
                    "number of vertices in a Digraph must be nonnegative"
            )
            inDegree.clear()
            adj.clear()
            V.clear()
            (0 until totalV).forEach { V.add(Vertex(it, totalV)) }

            val E: Int = stream.readInt();
            if (E < 0) throw IllegalArgumentException(
                    "number of edges in a Digraph must be nonnegative"
            )
            (0 until E).forEach { _ ->
                val v = Vertex(stream.readInt(), totalV)
                val w = Vertex(stream.readInt(), totalV)
                addEdge(v, w)
            }
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException(
                    "invalid input format in Graph constructor", e
            )
        }
    }

    fun addEdge(v: Vertex, w: Vertex) {
        adj.getOrPut(v, { mutableListOf() }).add(w)
        when(val degree = inDegree[w]) {
            null -> inDegree[w] = 1
            else -> inDegree[w] = degree + 1
        }
        E++
    }

    fun adj(v: Vertex): Iterable<Vertex> = adj[v] ?: mutableListOf()

    fun outDegree(v: Vertex): Int = adj[v]?.size ?: 0

    fun inDegree(v: Vertex): Int = inDegree[v] ?: 0

    override fun toString(): String {
        val prefix = "${V.size} vertices, $E edges"
        val data = adj.toSortedMap().map { (v, adj_v) ->
            "$v:${adj_v.fold(
                    "",
                    { acc, w -> "$acc $w"}
            )}"
        } .joinToString(R.newline())
        return listOf(prefix, data).joinToString(R.newline())
    }
}
