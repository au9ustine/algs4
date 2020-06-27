package com.github.t1anchen.algs4.v2.graph.undirected.paths

interface Paths {
    fun hasPathTo(v: Int): Boolean
    fun pathTo(v: Int): Iterable<Int>
}
