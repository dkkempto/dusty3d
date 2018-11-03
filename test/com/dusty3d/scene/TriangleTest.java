package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getNormal() {
        Triangle t = new Triangle(
                new Vector(1,1,1),
                new Vector(1,-1,1),
                new Vector(1,0,-1)
        );

        Vector n = t.getNormal(0,0);
        assertEquals(new Vector(1,0,0), n);
    }

    @Test
    void rotate() {
    }

    @Test
    void rotate1() {
    }

    @Test
    void translate() {
        Triangle t = new Triangle();
        t.translate(new Vector(1,1,1));

        assertEquals(new Vector(0,1,1), t.getP0());
        assertEquals(new Vector(1,1,2), t.getP1());
        assertEquals(new Vector(2,1,1), t.getP2());
    }

    @Test
    void moveTo() {
        Triangle t = new Triangle(
                new Vector(1,0,1),
                new Vector(2,0,2),
                new Vector(3,0,1)
        );
        t.moveTo(new Vector(0,0,0));

        assertEquals(new Vector(0,0,0), t.getP0());
        assertEquals(new Vector(1,0,1), t.getP1());
        assertEquals(new Vector(2,0,0), t.getP2());
    }

    @Test
    void getIntersection() {
        Triangle t = new Triangle(
                new Vector(5,5,5),
                new Vector(10,15,4),
                new Vector(15,5,3)
        );

        Ray r = new Ray(
                new Vector(9,5,-5),
                new Vector(0.1f,0.1f,0.8f)
        );

        Intersection i = t.getIntersection(r);
        assertTrue(i.didHit());
        assertEquals(new Vector(10.121951f, 6.121951f, 3.9756098f), i.getIntersect());
    }

    @Test
    void doesIntersect() {
    }
}