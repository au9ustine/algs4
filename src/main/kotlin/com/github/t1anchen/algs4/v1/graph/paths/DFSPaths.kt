package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.Vertex

/**
 * Application:
 * - Flood fill
 */
@Deprecated("v1")
class DFSPaths : Paths {
    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val s: Vertex

    constructor(g: Graph, s: Vertex) {
        this.s = s
        marked.clear()
        edgeTo.clear()
        dfs(g, s)
    }

    fun dfs(g: Graph, v: Vertex) {
        marked.add(v)
        for (w: Vertex in g.adj(v)) {
            if (w !in marked) {
                edgeTo[w] = v
                dfs(g, w)
            }
        }
    }

    override fun hasPathTo(v: Vertex): Boolean = v in marked

    override fun pathTo(v: Vertex): Iterable<Vertex> =
            when (hasPathTo(v)) {
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
