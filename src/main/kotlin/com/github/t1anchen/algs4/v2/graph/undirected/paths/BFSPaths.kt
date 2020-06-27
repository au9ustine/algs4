package com.github.t1anchen.algs4.v2.graph.undirected.paths

import com.github.t1anchen.algs4.v2.graph.undirected.Graph
import java.util.*


class BFSPaths {
    val marked: Array<Boolean>
    val edgeTo: Array<Int>
    val distTo: Array<Int>

    /**
     * 给定无向图 G 和源节点 s,
     * 进行宽度优先搜索路径
     */
    constructor(G: Graph, s: Int) {
        marked = Array(G.V) { false }
        distTo = Array(G.V) { 0 }
        edgeTo = Array(G.V) { 0 }
        Graph.assertValidVertex(s, G.V)
        bfs(G, s)

        assert(check(G, s))
    }

    fun bfs(G: Graph, s: Int) {
        val q: Queue<Int> = LinkedList()
        (0 until G.V).forEach { v ->
            distTo[v] = Graph.INFINITY
        }
        distTo[s] = 0
        marked[s] = true
        q.add(s)

        while (q.isNotEmpty()) {
            val v: Int = q.poll()
            G.adj[v].forEach { w ->
                if (!marked[w]) {
                    edgeTo[w] = v
                    distTo[w] = distTo[v] + 1
                    marked[w] = true
                    q.add(w)
                }
            }
        }
    }

    fun hasPathTo(v: Int): Boolean {
        Graph.assertValidVertex(v, marked.size)
        return marked[v]
    }

    fun pathTo(v: Int): Iterable<Int> {
        Graph.assertValidVertex(v, marked.size)
        val path = Stack<Int>()
        if (!hasPathTo(v)) return path
        var x: Int = v
        while (distTo[x] != 0) {
            path.push(x)
            x = edgeTo[x]
        }
        path.push(x)
        return path
    }

    fun check(G: Graph, s: Int): Boolean {
        // assure distTo[s] = 0
        if (distTo[s] != 0) {
            println("distTo[s] = ${distTo[s]}")
            return false
        }

        // assure each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        (0 until G.V).forEach { v ->
            G.adj[v].forEach { w ->

            }
        }

    }
}
