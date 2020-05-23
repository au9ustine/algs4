package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.utils.R

class Graph {
    val V: MutableList<UndirectedVertex> = mutableListOf()
    var E: Int = 0

    // [2020-05-22T22:30:58+0800] 本来想尝试用范型，然而在进行CRUD操作时发现需要重写 put
    // 方法。后重新尝试用 java 做了一遍范型，发现还是无法在List<T>中add(T)，因为 int 与 T
    // 之间没有建立类型关系。所以从这次的教训来看，使用范型的抽象，虽然能保证类型一致，但是灵活
    // 性上的 tradeoff 代价十分昂贵，仍然不如基于数学和数字的抽象
    //
    // [2020-05-23T14:44:07+0800] 今天又试了一遍用 UndirectedVertex，发现因为
    // MutableMap 比较 key 的时候默认对于 Reference Object 采取比较引用，如果要像 Int
    // 那样比较值的话，则需要重定义一个类并且重写 MutableMap 的键值对的比较方法。还是验证了
    // 之前的那条经验：基于基本类型的抽象远比复合类型的抽象在 tradeoff 上要有效的多。
    val adj: MutableMap<Int, MutableList<UndirectedVertex>> = mutableMapOf()

    constructor(V: Int) {
        if (V < 0)
            throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_vertice")
            )
        this.V.clear()
        (0 until V).forEach {
            val tmpV = UndirectedVertex(it, V)
            this.V.add(tmpV)
            adj[it] = mutableListOf()
        }
    }

    constructor(stream: In) {
        try {
            val totalV = stream.readInt()
            if (totalV < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_vertice")
            )
            V.clear()
            (0 until totalV).forEach { V.add(UndirectedVertex(it, totalV)) }

            val E: Int = stream.readInt();
            if (E < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_edges")
            )
            (0 until E).forEach { _ ->
                val v = UndirectedVertex(stream.readInt(), totalV)
                val w = UndirectedVertex(stream.readInt(), totalV)
                addEdge(v, w)
            }
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException(
                    "invalid input format in Graph constructor", e
            )
        }
    }

    private fun validateVertex(v: Int) {
        if (v < 0 || v >= V.size)
            throw IllegalArgumentException(
                    "vertex $v is not between 0 and ${V - 1}"
            )
    }

    fun addEdge(v: UndirectedVertex, w: UndirectedVertex) {
        E++;
        val vId = v.value
        val wId = w.value
        adj.getOrPut(vId, { mutableListOf() }).add(w)
        adj.getOrPut(wId, { mutableListOf() }).add(v)
    }

    fun adj(v: Int): Iterable<UndirectedVertex> {
        validateVertex(v)
        return adj.getOrDefault(v, mutableListOf())
    }

    fun adj(v: UndirectedVertex): Iterable<UndirectedVertex> {
        validateVertex(v.value)
        return adj.getOrDefault(v.value, mutableListOf())
    }

    fun degree(v: Int): Int {
        validateVertex(v)
        return adj.getOrDefault(v, mutableListOf()).size
    }

    override fun toString(): String {
        val lineSep = System.getProperty("line.separator")

        // [2020-05-19T21:56:48+0800] Here use "$v:$..." instead of "$v: $..."
        // because somehow the latter adds one extra space, which is not
        // expected
        val prefix = "${V.size} vertices, $E edges$lineSep"
        val entries = adj.toSortedMap().map { (v, adj_v) ->
                    "$v:${adj_v.fold(
                            "",
                            { acc, w -> "$acc $w" }
                    )}"
                }
        val representable = entries.joinToString(lineSep)
        return prefix + representable
    }

}
