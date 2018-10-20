package com.dusty3d.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void plus() {
        Vector v1 = new Vector(0, 0, 0);
        Vector v2 = new Vector(1, 2, 3);
        Vector res = v1.plus(v2);
        assertEquals(1, res.getX());
        assertEquals(2, res.getY());
        assertEquals(3, res.getZ());
    }

    @Test
    void minus() {
        Vector v1 = new Vector(0, 0, 0);
        Vector v2 = new Vector(1, 2, 3);
        Vector res = v1.minus(v2);
        assertEquals(-1, res.getX());
        assertEquals(-2, res.getY());
        assertEquals(-3, res.getZ());
    }

    @Test
    void scale() {
        Vector v1 = new Vector(0, 1, 2);
        Vector res = v1.scale(2);
        assertEquals(0, res.getX());
        assertEquals(2, res.getY());
        assertEquals(4, res.getZ());
    }

    @Test
    void dot() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(1, 5, 7);
        float res = v1.dot(v2);
        assertEquals(32, res);
    }

    @Test
    void cross() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        Vector res = v1.cross(v2);
        assertEquals(-3, res.getX());
        assertEquals(6, res.getY());
        assertEquals(-3, res.getZ());
    }
}