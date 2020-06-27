package com.github.t1anchen.algs4.v1.graph

import com.github.t1anchen.algs4.utils.In
import com.github.t1anchen.algs4.utils.R

@Deprecated("v1")
class Graph {
    val V: Int
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
        this.V = V
        (0 until V).forEach {
            adj[Vertex(it, V)] = mutableListOf()
        }
    }

    constructor(stream: In) {
        try {
            val V = stream.readInt()
            if (V < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_vertice")
            )
            this.V = V

            val E: Int = stream.readInt();
            if (E < 0) throw IllegalArgumentException(
                    R.str("errmsg.graph.negative_edges")
            )
            (0 until E).forEach { _ ->
                val v = Vertex(stream.readInt(), V)
                val w = Vertex(stream.readInt(), V)
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
        this.V = g.V
        this.adj.clear()

        // [2020-05-30T21:46:21+0800] 直接使用 putAll 或者 toMap 并不能够生成
        // 深拷贝，而是生成了一个新的 Map 的对象，但是键值对的引用仍指向原对象
        // 所以需要在生成新的 Map 的同时，对 Map 中所包含的键值对做 *递归地* 深拷贝
        //
        // [2020-05-30T22:02:48+0800]
        // 对于复杂的对象（例如嵌套了十几个不同的引用类型的对象）递归手写深拷贝是不现实的，所以
        // 一种比较方便但是可能性能会受损的方法是将其序列化后再还原
        g.adj.forEach { (v, vAdj) ->
            this.adj[Vertex(v)] = vAdj.map { Vertex(it) }.toMutableList()
        }
    }

    fun addEdge(v: Vertex, w: Vertex) {
        E++;
        adj.getOrPut(v, { mutableListOf() }).add(w)
        adj.getOrPut(w, { mutableListOf() }).add(v)
    }

    fun adj(v: Vertex): Iterable<Vertex> = adj[v] ?: mutableListOf()

    fun degree(v: Vertex): Int = this.adj.getOrDefault(v, mutableListOf()).size

    fun V(): Iterable<Vertex> = adj.keys.sorted()

    override fun toString(): String {
        val lineSep = System.getProperty("line.separator")

        // [2020-05-19T21:56:48+0800] Here it used "$v:$..." rather than "$v: $
        // ..." as somehow the latter adds one unexpected space
        val prefix = "$V vertices, $E edges$lineSep"
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
