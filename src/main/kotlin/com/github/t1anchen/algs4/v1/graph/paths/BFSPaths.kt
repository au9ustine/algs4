package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.Vertex
import java.util.*

/**
 * Application
 * - Routing
 * - Kevin Bacon numbers
 * - Erdos numbers
 */
@Deprecated("v1")
class BFSPaths : Paths {

    companion object {
        const val INFINITY: Int = Int.MAX_VALUE
    }

    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val distTo: MutableMap<Vertex, Int> = mutableMapOf()

    constructor(g: Graph, s: Vertex) {
        for (v: Vertex in g.V()) {
            distTo[v] = INFINITY
        }
        bfs(g, s)
    }

    fun bfs(g: Graph, s: Vertex) {
        val q = LinkedList<Vertex>()
        for (v: Vertex in g.V()) {
            distTo[v] = INFINITY
        }
        distTo[s] = 0
        marked.add(s)
        q.add(s)

        while (!q.isEmpty()) {
            val v: Vertex = q.poll()
            for (w: Vertex in g.adj(v)) {
                if (w !in marked) {
                    edgeTo[w] = v
                    distTo[v]?.let { distTo[w] = it + 1 }
                    marked.add(w)
                    q.add(w)
                }
            }
        }
    }

    override fun hasPathTo(v: Vertex): Boolean = v in marked

    fun distTo(v: Vertex): Int = distTo[v] ?: INFINITY

    override fun pathTo(v: Vertex): Iterable<Vertex> =
            when(hasPathTo(v)) {
                false -> emptyList()
                else -> {
                    val path = mutableListOf<Vertex>()
                    var x = v
                    while (distTo[x] != 0) {
                        path.add(x)
                        x = edgeTo[x]!!
                    }
                    path.add(x)
                    path.reversed()
                }
            }
}
