package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.R

class ConnectedComponent {
    val verticeVisited: Array<Boolean>
    val idsOfCC: Array<Int>
    val sizesOfCC: Array<Int>
    var counted = 0
    val g: Graph

    constructor(g: Graph) {
        this.g = g
        verticeVisited = Array(g.V.size) { false }
        idsOfCC = Array(g.V.size) { 0 }
        sizesOfCC = Array(g.V.size) { 0 }

        for (v: UndirectedVertex in g.V) {
            val vertexId = v.value
            if (!verticeVisited[vertexId]) {
                dfs(g, v)
                counted++
            }
        }
    }

    fun dfs(g: Graph, v: UndirectedVertex) {
        val vertexId = v.value
        verticeVisited[vertexId] = true
        idsOfCC[vertexId] = counted
        sizesOfCC[counted]++
        for (w: UndirectedVertex in g.adj(v)) {
            if (!verticeVisited[w.value]) {
                dfs(g, w)
            }
        }
    }

    fun count(): Int = counted
    fun size(v: UndirectedVertex): Int {
        val vertexId = v.value
        return sizesOfCC[idsOfCC[vertexId]]
    }

    override fun toString(): String {
        val components: Array<MutableList<UndirectedVertex>> = Array(this.counted) {
            mutableListOf<UndirectedVertex>()
        }
        val header = "$counted components"
        for (v: UndirectedVertex in g.V) {
            val vertexId = v.value
            components[idsOfCC[vertexId]].add(v)
        }
        return header + R.newline() + (0 until counted).map { componentId ->
            components[componentId].toString()
        }.joinToString(R.newline())
    }
}
