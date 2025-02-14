package com.example;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Enclosed.class)
public class TriangleTest {

    private final int a, b, c;
    private final boolean expected;

    public TriangleTest(int a, int b, int c, boolean expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        List<Object[]> testCases = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("testCases.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                boolean expected = Boolean.parseBoolean(parts[3]);
                testCases.add(new Object[]{a, b, c, expected});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testCases;
    }

    @Test
    public void testIsTriangle() {
        assertEquals(expected, Triangle.isTriangle(a, b, c));
    }

    @Test
    public void nonParameterizedTest() {
        assertTrue(Triangle.isTriangle(3, 4, 5));
        assertTrue(Triangle.isTriangle(1, 1, 1));
        assertFalse(Triangle.isTriangle(1, 10, 12));
    }
}
