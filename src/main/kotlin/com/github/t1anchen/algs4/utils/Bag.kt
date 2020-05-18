package com.github.t1anchen.algs4.utils

class Bag<T> : Iterable<T> {

    // 默认情况下, Bag 实现一个空集合
    private var first: Node<T>? = null
    private var n: Int = 0

    inner class Node<T>(var item: T, var next: Node<T>?)

    /**
     * 判断这个 Bag 是否为空
     */
    fun isEmpty(): Boolean {
        return first == null
    }

    /**
     * 返回这个 Bag 中的成员个数
     */
    fun size(): Int = n

    fun add(item: T) {
        var oldFirst: Node<T>? = first
        first = Node(item, oldFirst)
        n++
    }

    override fun toString(): String = this.toList().toString()

    override fun iterator(): Iterator<T> = LinkedIterator(first)

    private inner class LinkedIterator<T> : Iterator<T> {
        private var current: Node<T>?

        constructor(first: Node<T>?) {
            current = first
        }

        override fun hasNext(): Boolean = current != null

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            val item: T = current!!.item
            current = current!!.next
            return item
        }
    }
}

