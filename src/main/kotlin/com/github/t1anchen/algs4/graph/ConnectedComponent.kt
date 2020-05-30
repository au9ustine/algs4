package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.R

/**
 * Application
 * - Study spread of STDs
 * - Particle detection
 */
class ConnectedComponent {
    val verticeVisited: Array<Boolean>
    val idsOfCC: Array<Int>
    val sizesOfCC: Array<Int>
    var counted = 0
    val g: Graph

    constructor(g: Graph) {
        this.g = g
        verticeVisited = Array(g.V) { false }
        idsOfCC = Array(g.V) { 0 }
        sizesOfCC = Array(g.V) { 0 }

        for (v: Vertex in g.V()) {
            val vertexId = v.value
            if (!verticeVisited[vertexId]) {
                dfs(g, v)
                counted++
            }
        }
    }

    fun dfs(g: Graph, v: Vertex) {
        val vertexId = v.value
        verticeVisited[vertexId] = true
        idsOfCC[vertexId] = counted
        sizesOfCC[counted]++
        for (w: Vertex in g.adj(v)) {
            if (!verticeVisited[w.value]) {
                dfs(g, w)
            }
        }
    }

    fun count(): Int = counted
    fun size(v: Vertex): Int {
        val vertexId = v.value
        return sizesOfCC[idsOfCC[vertexId]]
    }

    override fun toString(): String {
        val components: Array<MutableList<Vertex>> = Array(this.counted) {
            mutableListOf<Vertex>()
        }
        val header = "$counted components"
        for (v: Vertex in g.V()) {
            val vertexId = v.value
            components[idsOfCC[vertexId]].add(v)
        }
        return header + R.newline() + (0 until counted).map { componentId ->
            components[componentId].toString()
        }.joinToString(R.newline())
    }
}
