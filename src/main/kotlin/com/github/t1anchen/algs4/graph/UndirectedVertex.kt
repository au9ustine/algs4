package com.github.t1anchen.algs4.graph

class UndirectedVertex : Comparable<UndirectedVertex> {
    val value: Int

    constructor(value: Int, valueUpperLimit: Int) {
        require(!(value < 0 || value >= valueUpperLimit)) {
            "vertex " + value + " is not between 0 and " + (valueUpperLimit - 1)
        }
        this.value = value
    }

    override fun equals(other: Any?): Boolean {
        return value.equals(other)
    }

    override fun compareTo(other: UndirectedVertex): Int {
        return value.compareTo(other.value)
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return value.toString()
    }

}
