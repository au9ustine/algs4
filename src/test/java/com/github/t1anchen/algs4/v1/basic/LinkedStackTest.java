package com.github.t1anchen.algs4.v1.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {

    @Test
    public void pushAndPop() {
        String[] xs = "LINKEDLISTSTACKEXAMPLE".split("");
        Stack<String> stack = new LinkedStack<>();
        for (String x : xs) {
            stack.push(x);
        }
        assertEquals(22, stack.size());
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        assertEquals("ELPMAXEKCATSTSILDEKNIL", builder.toString());
    }

    @Test
    public void testPeekAndToString() {
        String[] xs = "LINKEDLISTSTACKEXAMPLE".split("");
        Stack<String> stack = new LinkedStack<>();
        for (String x : xs) {
            stack.push(x);
        }
        String expected = "E L P M A X E K C A T S T S I L D E K N I L ";
        assertEquals(expected, stack.toString());
    }
}
