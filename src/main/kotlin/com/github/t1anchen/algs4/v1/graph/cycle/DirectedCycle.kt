package com.github.t1anchen.algs4.v1.graph.cycle

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex

@Deprecated("v1")
class DirectedCycle {
    val marked = mutableSetOf<Vertex>()
    val edgeTo = mutableMapOf<Vertex, Vertex>()
    val onStack = mutableSetOf<Vertex>()
    val cycle = mutableListOf<Vertex>()

    constructor(g: Digraph) {
        for (v: Vertex in g.V()) {
            println(v)
            if (v !in marked && cycle.isEmpty())
                dfs(g, v)
        }
    }

    fun dfs(g: Digraph, v: Vertex) {

        onStack.add(v)
        marked.add(v)

        for (w: Vertex in g.adj(v)) {
            when {
                cycle.isNotEmpty() -> return@dfs
                w !in marked -> {
                    edgeTo[w] = v
                    dfs(g, w)
                }
                w in onStack -> {
                    cycle.clear()
                    var x = v
                    while (x != w) {
                        cycle.add(x)
                        x = edgeTo[x]!!
                    }
                    cycle.add(w)
                    cycle.add(v)
                    assert(check())
                }
            }
        }
        onStack.remove(v)

    }

    fun hasCycle(): Boolean = cycle.isNotEmpty()

    fun cycle(): Iterable<Vertex> = cycle.asIterable()

    fun check(): Boolean {
        if (hasCycle()){
            var first = Vertex.NIL
            var last = Vertex.NIL
            for (v: Vertex in cycle()){
                if (first == Vertex.NIL)
                    first = v
                last = v
            }
            if (first != last) {
                System.err.printf("cycle begins with $first and ends with " +
                        "$last")
                return false
            }
        }
        return true
    }
}
