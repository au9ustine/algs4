package com.github.t1anchen.algs4.graph.paths

import com.github.t1anchen.algs4.graph.Graph
import com.github.t1anchen.algs4.graph.Vertex
import java.util.*

/**
 * Application
 * - Routing
 * - Kevin Bacon numbers
 * - Erdos numbers
 */
class BreadthFirstPaths : Paths {

    companion object {
        val INFINITY: Int = Int.MAX_VALUE
    }

    val marked: MutableSet<Vertex> = mutableSetOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val distTo: MutableMap<Vertex, Int> = mutableMapOf()

    constructor(G: Graph, s: Vertex) {
        for (v: Vertex in G.V) {
            distTo[v] = INFINITY
        }
        bfs(G, s)
    }

    fun bfs(G: Graph, s: Vertex) {
        val q = LinkedList<Vertex>()
        for (v: Vertex in G.V) {
            distTo[v] = INFINITY
        }
        distTo[s] = 0
        marked.add(s)
        q.add(s)

        while (!q.isEmpty()) {
            val v: Vertex = q.poll()
            for (w: Vertex in G.adj(v)) {
                if (w !in marked) {
                    edgeTo[w] = v
                    distTo[w] = distTo[v]!! + 1
                    marked.add(w)
                    q.add(w)
                }
            }
        }
    }

    override fun hasPathTo(v: Vertex): Boolean = v in marked

    fun distTo(v: Vertex): Int = when(val dv = distTo[v]) {
        null -> INFINITY
        else -> dv
    }

    override fun pathTo(v: Vertex): Iterable<Vertex>? =
            when(hasPathTo(v)) {
                false -> null
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
