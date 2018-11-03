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

        assertEquals(true, s.getIntersection(r).didHit());
        assertEquals(false, s.getIntersection(miss).didHit());

        assertEquals(false, s.getIntersection(leftBottom).didHit());
        assertEquals(false, s.getIntersection(leftTop).didHit());
        assertEquals(false, s.getIntersection(rightBottom).didHit());
        assertEquals(false, s.getIntersection(rightTop).didHit());
    }
}