package com.dusty3d.scene;

import com.dusty3d.math.Ray;
import com.dusty3d.math.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getIntersection() {
        Sphere s = new Sphere(new Vector(0, 10, 0));
        Ray r = new Ray(new Vector(), new Vector(0, 1, 0));
        Ray miss = new Ray(new Vector(), new Vector(1, 0, 0));

        Ray leftBottom = new Ray(new Vector(), new Vector(-0.86602545f, 1.0f, -0.6495191f));
        Ray leftTop = new Ray(new Vector(), new Vector(-0.86602545f, 1.0f, 0.6495191f));
        Ray rightBottom = new Ray(new Vector(), new Vector(0.86602545f, 1.0f, -0.6495191f));
        Ray rightTop = new Ray(new Vector(), new Vector(0.86602545f, 1.0f, 0.6495191f));

        assertTrue(s.getIntersection(r).didHit());
        assertFalse(s.getIntersection(miss).didHit());

        assertFalse(s.getIntersection(leftBottom).didHit());
        assertFalse(s.getIntersection(leftTop).didHit());
        assertFalse(s.getIntersection(rightBottom).didHit());
        assertFalse(s.getIntersection(rightTop).didHit());
    }
}