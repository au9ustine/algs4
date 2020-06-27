package com.github.t1anchen.algs4.v1.graph.cc

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.Vertex
import com.github.t1anchen.algs4.utils.R

/**
 * Application
 * - Study spread of STDs
 * - Particle detection
 */
@Deprecated("v1")
class ConnectedComponent {
    val marked = mutableSetOf<Vertex>()
    val id = mutableMapOf<Vertex, Int>()
    val size: Array<Int>
    var counted = 0
    val g: Graph

    constructor(g: Graph) {
        this.g = g
        id.clear()
        size = Array(g.V) { 0 }

        g.V().forEach { v ->
            if (v !in marked) {
                dfs(g, v)
                counted++
            }
        }
    }

    fun dfs(g: Graph, v: Vertex) {
        marked.add(v)
        id[v] = counted
        size[counted]++
        for (w: Vertex in g.adj(v)) {
            if (w !in marked) {
                dfs(g, w)
            }
        }
    }

    fun count(): Int = counted
    fun size(v: Vertex): Int = when (val cc = id[v]) {
        null -> -1
        else -> size[cc]
    }

    override fun toString(): String {
        val components: Array<MutableList<Vertex>> = Array(this.counted) {
            mutableListOf<Vertex>()
        }
        val header = "$counted components"
        g.V().forEach { v ->
            id[v]?.let { components[it].add(v) }
        }
        return header + R.newline() + (0 until counted).map { componentId ->
            components[componentId].toString()
        }.joinToString(R.newline())
    }
}
