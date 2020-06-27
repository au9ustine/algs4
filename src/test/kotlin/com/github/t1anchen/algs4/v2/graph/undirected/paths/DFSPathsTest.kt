package com.github.t1anchen.algs4.v2.graph.undirected.paths

import com.github.t1anchen.algs4.v2.graph.GraphTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DFSPathsTest : GraphTest() {
    @Test
    fun testHasPathTo() {
        val dfp = DFSPaths(g, 3)
        assertTrue(dfp.hasPathTo(0))
        assertFalse(dfp.hasPathTo(7))
    }

    @Test
    fun testPathTo() {
        val dfp = DFSPaths(g, 0)
        val actual = dfp.pathTo(3).toString()
        val expected = "[0, 5, 4, 3]"
        assertEquals(expected, actual)
    }
}
