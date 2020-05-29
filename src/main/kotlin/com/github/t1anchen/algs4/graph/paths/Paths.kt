package com.github.t1anchen.algs4.graph.paths

import com.github.t1anchen.algs4.graph.Vertex

interface Paths {
    fun hasPathTo(v: Vertex): Boolean
    fun pathTo(v: Vertex): Iterable<Vertex>?
}
