package com.github.t1anchen.algs4.v1.graph.sort

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.v1.graph.Vertex
import java.util.*

@Deprecated("v1")
class Topological {
    val order: Queue<Vertex> = LinkedList<Vertex>()
    val ranks: MutableMap<Vertex, Int> = mutableMapOf()

    constructor(g: Digraph) {
        val inDegree = mutableMapOf<Vertex, Int>()
        g.V().forEach { v -> inDegree[v] = g.inDegree(v) }
        var count = 0

        val queue: Queue<Vertex> = LinkedList()
        g.V().filter { v ->
            inDegree[v] == 0 || !inDegree.containsKey(v)
        }.forEach {
            queue.add(it)
        }

        while (!queue.isEmpty()) {
            val v: Vertex = queue.poll()
            order.add(v)
            ranks[v] = count++
            g.adj(v).forEach { w ->
                inDegree[w]?.let { inDegree[w] = it - 1 }
                if (inDegree[w] == 0 || !inDegree.containsKey(w))
                    queue.add(w)
            }
        }

        if (count != g.V) {
            order.clear()
        }

        assert(check(g))
    }

    fun order(): Iterable<Vertex> = order.asIterable()

    fun hasOrder(): Boolean = !order.isEmpty()

    fun rank(v: Vertex): Int = when (hasOrder()) {
        true -> ranks[v] ?: -1
        else -> -1
    }

    fun check(g: Digraph): Boolean {
        if (hasOrder()) {
            val found = mutableSetOf<Vertex>()
            g.V().filter {
                it.value == rank(it)
            }.forEach {
                found.add(it)
            }

            g.V().forEach { i ->
                if (i !in found) {
                    System.err.println("No vertex with rank $i")
                    return false
                }
            }

            g.V().forEach { v ->
                g.adj(v).forEach { w ->
                    if (rank(v) > rank(w)) {
                        System.err.printf("$v-$w: rank($v) = ${rank(v)}, rank" +
                                "($v) = ${rank(w)}")
                        return false
                    }
                }
            }

            var r = 0
            order().forEach { v ->
                if (rank(v) != r) {
                    System.err.println("order() and rank() inconsistent")
                    return false
                }
                r++
            }

        }
        return true
    }


}
