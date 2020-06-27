package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex
import java.util.*

/**
 * Application
 * - Web crawler
 *
 */
@Deprecated("v1")
class BFSDirectedPaths {
    companion object {
        const val INFINITY: Int = Int.MAX_VALUE
    }

    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val distTo: MutableMap<Vertex, Int> = mutableMapOf()

    constructor(g: Digraph, s: Vertex) {
        g.V().forEach { distTo[it] = INFINITY }
        bfs(g, s)
    }

    fun bfs(g: Digraph, s: Vertex) {
        val q = LinkedList<Vertex>()
        marked.add(s)
        distTo[s] = 0
        q.add(s)

        while (!q.isEmpty()) {
            val v = q.poll()
            g.adj(v).forEach { w ->
                if (w !in marked) {
                    edgeTo[w] = v
                    distTo[v]?.let { distTo[w] = it + 1 }
                    marked.add(w)
                    q.add(w)
                }
            }
        }
    }

    fun hasPathTo(v: Vertex): Boolean = v in marked

    fun distTo(v: Vertex): Int = distTo[v] ?: INFINITY

    fun pathTo(v: Vertex): Iterable<Vertex> =
            when (hasPathTo(v)) {
                false -> emptyList()
                else -> {
                    val path = mutableListOf<Vertex>()
                    var x = v;
                    while (distTo[x] != 0) {
                        path.add(x)
                        x = edgeTo[x]!!
                    }
                    path.add(x)
                    path.reversed()
                }
            }
}
