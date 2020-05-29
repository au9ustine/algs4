package com.github.t1anchen.algs4.graph

import java.lang.IllegalArgumentException

class Vertex : Comparable<Vertex> {

    val value: Int

    constructor(value: Int, valueUpperLimit: Int) {
        when {
            value < 0 || value >= valueUpperLimit -> throw
            IllegalArgumentException(
                    "vertex " + value + " is not between 0 and " + (valueUpperLimit - 1)
            )
            else -> this.value = value
        }
    }

    override fun equals(other: Any?): Boolean =
        when(other) {
            is Vertex -> this.value == other.value
            else -> false
        }

    override fun compareTo(other: Vertex): Int {
        return value.compareTo(other.value)
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }

}
