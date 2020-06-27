package com.github.t1anchen.algs4.v2.graph.undirected.paths

import com.github.t1anchen.algs4.v2.graph.undirected.Graph


class DFSPaths : Paths {
    val marked: Array<Boolean>
    val edgeTo: Array<Int>
    val s: Int

    override fun hasPathTo(v: Int): Boolean {
        Graph.assertValidVertex(v, marked.size)
        return marked[v]
    }

    override fun pathTo(v: Int): Iterable<Int> {
        Graph.assertValidVertex(v, marked.size)
        if (!hasPathTo(v)) emptyList<Int>()
        val path = mutableListOf<Int>()
        var x = v
        while (x != s) {
            path.add(x)
            x = edgeTo[x]
        }
        path.add(s)
        return path.reversed()
    }

    constructor(G: Graph, s: Int) {
        this.s = s
        marked = Array(G.V) { false }
        edgeTo = Array(G.V) { 0 }
        Graph.assertValidVertex(this.s, G.V)
        dfs(G, s)
    }

    fun dfs(G: Graph, v: Int) {
        marked[v] = true
        G.adj[v].forEach { w ->
            if (!marked[w]) {
                edgeTo[w] = v
                dfs(G, w)
            }
        }
    }
}
