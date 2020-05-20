package com.github.t1anchen.algs4.graph

class Edge<T>(
        val start: UndirectedVertex<T>,
        val end: UndirectedVertex<T>
) {
    init {
        start.adj.add(end)
        end.adj.add(start)
    }
}
