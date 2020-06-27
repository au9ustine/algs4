package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex

/**
 * Reachability Application
 * - program control-flow analysis
 * - mark-sweep garbage collector
 */
@Deprecated("v1")
class DFSDirectedPaths {
    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val s: Vertex

    constructor(g: Digraph, s: Vertex) {
        this.s = s
        dfs(g, s)
    }

    fun dfs(g: Digraph, v: Vertex) {
        marked.add(v)
        g.adj(v).forEach { w ->
            if (w !in marked) {
                edgeTo[w] = v
                dfs(g, w)
            }
        }
    }

    fun hasPathTo(v: Vertex): Boolean = v in marked

    fun pathTo(v: Vertex): Iterable<Vertex> = when(hasPathTo(v)) {
        false -> emptyList()
        else -> {
            val path = mutableListOf<Vertex>()
            var x = v
            while (x != s) {
                path.add(x)
                x = edgeTo[x]!!
            }
            path.add(s)
            path.reversed()
        }
    }
}
