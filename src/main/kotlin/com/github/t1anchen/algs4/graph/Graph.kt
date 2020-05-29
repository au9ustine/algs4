package com.github.t1anchen.algs4.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.utils.R

class Graph {
    val V: MutableList<Vertex> = mutableListOf()
    var E: Int = 0

    // [2020-05-22T22:30:58+0800] 本来想尝试用范型，然而在进行CRUD操作时发现需要重写 put
    // 方法。后重新尝试用 java 做了一遍范型，发现还是无法在List<T>中add(T)，因为 int 与 T
    // 之间没有建立类型关系。所以从这次的教训来看，使用范型的抽象，虽然能保证类型一致，但是灵活
    // 性上的 tradeoff 代价十分昂贵，仍然不如基于数学和数字的抽象
    //
    // [2020-05-23T14:44:07+0800] 今天又试了一遍用 Vertex，发现因为 MutableMap 比较 key
    // 的时候默认对于 Reference Object 采取比较引用，如果要像 Int 那样比较值的话，则需要重
    // 定义一个类并且重写 MutableMap 的键值对的比较方法。还是验证了之前的那条经验：基于基本类
    // 型的抽象远比复合类型的抽象在 tradeoff 上要有效的多。
    //
    // [2020-05-29T17:00:39+0800] 今天发现通过对 Map 的源码研读，发现键值比较采取的是对键
    // 的对象调用 equals 方法，所以如果改写 equals 方法，使其比较的时候比较值而不是引用，就可
    // 以达到在 map 中比较值的效果，试验下来是可行的
    val adj: MutableMap<Vertex, MutableList<Vertex>> = mutableMapOf()

    constructor(V: Int) {
        if (V < 0)
            throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_vertice")
            )
        this.V.clear()
        (0 until V).forEach {
            val tmpV = Vertex(it, V)
            this.V.add(tmpV)
            adj[tmpV] = mutableListOf()
        }
    }

    constructor(stream: In) {
        try {
            val totalV = stream.readInt()
            if (totalV < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_vertice")
            )
            V.clear()
            (0 until totalV).forEach { V.add(Vertex(it, totalV)) }

            val E: Int = stream.readInt();
            if (E < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_edges")
            )
            (0 until E).forEach { _ ->
                val v = Vertex(stream.readInt(), totalV)
                val w = Vertex(stream.readInt(), totalV)
                addEdge(v, w)
            }
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException(
                    "invalid input format in Graph constructor", e
            )
        }
    }

    // Deep copy constructor
    constructor(g: Graph) {
        this.E = g.E
        this.V.clear()
        this.V.addAll(g.V)
        this.adj.clear()

        for (entry in g.adj.entries) {
            val (vertexValue, vertexConnected) = entry
            this.adj.getOrPut(vertexValue, { mutableListOf() }).addAll(vertexConnected)
        }
    }

    private fun validateVertex(v: Int) {
        if (v < 0 || v >= this.V.size)
            throw IllegalArgumentException(
                    "vertex $v is not between 0 and ${this.V - 1}"
            )
    }

    fun addEdge(v: Vertex, w: Vertex) {
        E++;
        val vId = v.value
        val wId = w.value
        adj.getOrPut(v, { mutableListOf() }).add(w)
        adj.getOrPut(w, { mutableListOf() }).add(v)
    }

//    fun adj(v: Int): Iterable<Vertex> {
//        validateVertex(v)
//        return adj.getOrDefault(v, mutableListOf())
//    }

    fun adj(v: Vertex): Iterable<Vertex> = adj.getOrDefault(v, mutableListOf())


//    fun degree(v: Int): Int {
//        validateVertex(v)
//        return adj.getOrDefault(v, mutableListOf()).size
//    }

    fun degree(v: Vertex): Int = this.adj.getOrDefault(v, mutableListOf()).size

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
