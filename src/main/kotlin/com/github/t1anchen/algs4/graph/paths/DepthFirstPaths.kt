package com.github.t1anchen.algs4.graph.paths

import com.github.t1anchen.algs4.graph.Graph
import com.github.t1anchen.algs4.graph.Vertex

/**
 * Application:
 * - Flood fill
 */
class DepthFirstPaths : Paths {
    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val s: Vertex

    constructor(G: Graph, s: Vertex) {
        this.s = s
        marked.clear()
        edgeTo.clear()
        dfs(G, s)
    }

    fun dfs(G: Graph, v: Vertex) {
        marked.add(v)
        for (w: Vertex in G.adj(v)) {
            if (w !in marked) {
                edgeTo[w] = v
                dfs(G, w)
            }
        }
    }

    override fun hasPathTo(v: Vertex): Boolean = v in marked

    override fun pathTo(v: Vertex): Iterable<Vertex>? =
            when (hasPathTo(v)) {
                false -> null
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
