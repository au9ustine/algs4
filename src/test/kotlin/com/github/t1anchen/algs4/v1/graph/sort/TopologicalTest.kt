package com.github.t1anchen.algs4.v1.graph.sort

import com.github.t1anchen.algs4.v1.graph.Digraph
import com.github.t1anchen.algs4.utils.In
import kotlin.test.Test

class TopologicalTest {
    @Test
    fun testInit() {
        val gGraphInputText = """12
            |16
            |0 4
            |2 1
            |2 1
            |2 7
            |4 9
            |5 11
            |5 7
            |5 4
            |6 2
            |6 9
            |6 5
            |7 1
            |8 4
            |9 7
            |10 11
            |11 8
        """.trimMargin()
        val stream = gGraphInputText.byteInputStream().buffered()
        val g = Digraph(In(stream))
        val sorter = Topological(g)
        println(sorter.order())
    }
}
