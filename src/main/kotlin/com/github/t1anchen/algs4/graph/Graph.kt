package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.Bag
import java.io.InputStream
import java.lang.IllegalArgumentException
import java.util.stream.Stream

public class Graph {
    private val V: Int
    private var E: Int = 0
    val adj: Array<Bag<Int>>

    constructor(V: Int) {
        if (V < 0)
            throw IllegalArgumentException("Number of vertices must be nonnegative")
        this.V = V
        adj = Array(V) { Bag<Int>()}
    }

}