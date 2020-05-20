package com.github.t1anchen.algs4.graph

import java.util.*

class UndirectedVertex<T> {
    val value: Optional<T>
    var marked: Boolean = false
    val adj: MutableList<UndirectedVertex<T>> = mutableListOf()
    constructor(value: T) {
        this.value = when(value) {
            is UInt -> Optional.of(value)
            value is Int && value > 0 -> Optional.of(value)
            else -> Optional.empty()
        }
    }
}
