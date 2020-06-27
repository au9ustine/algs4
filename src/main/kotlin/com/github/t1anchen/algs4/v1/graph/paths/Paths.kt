package com.github.t1anchen.algs4.v1.graph.paths

import com.github.t1anchen.algs4.v1.graph.Vertex

@Deprecated("v1")
interface Paths {
    fun hasPathTo(v: Vertex): Boolean
    // [2020-06-01T21:55:03+0800] 这里将 Iterable? 改成 Iterable，是尽量避免使用
    // null 而改为 empty 集合
    fun pathTo(v: Vertex): Iterable<Vertex>
}
