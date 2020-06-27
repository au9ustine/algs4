package com.github.t1anchen.algs4.v1.graph.cycle

import com.github.t1anchen.algs4.v1.graph.Graph
import com.github.t1anchen.algs4.v1.graph.Vertex
import com.github.t1anchen.algs4.v1.graph.Vertex.Companion.NIL
import java.util.*

@Deprecated("v1")
class Cycle {
    val marked: MutableMap<Vertex, Boolean> = mutableMapOf()
    val edgeTo: MutableMap<Vertex, Vertex> = mutableMapOf()
    val cycle: Stack<Vertex> = Stack()

    constructor(g: Graph) {
        if (hasSelfLoop(g)) return
        if (hasParallelEdges(g)) return
        g.V().forEach { v ->
            when (marked[v]) {
                true -> Unit
                else -> dfs(g, NIL, v)
            }
        }
    }

    fun hasSelfLoop(g: Graph): Boolean {
        g.V().forEach { v ->
            g.adj(v).forEach { w ->
                if (v == w) {
                    cycle.push(v)
                    cycle.push(v)
                    return true
                }
            }
        }
        return false
    }

    fun hasParallelEdges(g: Graph): Boolean {
        marked.clear()

        g.V().forEach { v ->
            g.adj(v).forEach { w ->
                marked[w]?.let {
                    if (it) {
                        cycle.clear()
                        cycle.push(v)
                        cycle.push(w)
                        cycle.push(v)
                        return true
                    }
                }
                marked[w] = true
            }

            g.adj(v).forEach {
                marked[it] = false
            }

        }
        return false
    }

    fun hasCycle(): Boolean = !cycle.isEmpty()

    fun cycle(): Iterable<Vertex> = cycle.asIterable()

    fun dfs(g: Graph, u: Vertex, v: Vertex) {
        marked[v] = true

        g.adj(v).forEach { w ->
            if (!cycle.isEmpty()) return
            when (marked[w]) {
                false -> {
                    edgeTo[w] = v
                    dfs(g, v, w)
                }
                else -> {
                    if (w != u) {
                        cycle.clear()
                        var x = v
                        while (x != w) {
                            cycle.push(x)
                            x = edgeTo[x]!!
                        }
                        cycle.push(w)
                        cycle.push(v)
                    }
                }
            }
        }
    }
}
