package com.github.t1anchen.algs4.v1.graph

import java.io.Serializable
import java.lang.IllegalArgumentException

@Deprecated("v1")
class Vertex : Comparable<Vertex>, Cloneable, Serializable {

    val value: Int

    companion object {
        val NIL = Vertex(-1)
    }

    constructor(value: Int, valueUpperLimit: Int) {
        when {
            value < 0 || value >= valueUpperLimit -> throw
            IllegalArgumentException(
                    "vertex " + value + " is not between 0 and " + (valueUpperLimit - 1)
            )
            else -> this.value = value
        }
    }

    private constructor(value: Int) {
        this.value = value
    }

    constructor(v: Vertex) {
        this.value = v.value
    }

    override fun clone(): Any {
        return Vertex(this)
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
