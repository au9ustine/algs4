package com.github.t1anchen.algs4.graph

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UndirectedVertexTest {
    @Test
    fun initValue() {
        val uIntPresented = UndirectedVertex(42U)
        assertTrue(uIntPresented.value.isPresent)
        val intPresented = UndirectedVertex(42)
        assertTrue(uIntPresented.value.isPresent)
        val negativeInt = UndirectedVertex(-42)
        assertFalse(negativeInt.value.isPresent)
        val floatNotPresented = UndirectedVertex(120.0)
        assertFalse(floatNotPresented.value.isPresent)

    }
}
