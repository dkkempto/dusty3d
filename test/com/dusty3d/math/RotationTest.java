package com.dusty3d.math;

import org.junit.jupiter.api.Test;

class RotationTest {

    @Test
    void rotateX() {
        Rotation rot = new Rotation();
        rot = rot.rotateX((float)Math.PI/2);
        System.out.println(rot.getMatrix());

    }

    @Test
    void rotateY() {
    }

    @Test
    void rotateZ() {
        Rotation rot = new Rotation();
        rot = rot.rotateZ((float)Math.PI);
        Vector o = new Vector(1f, 0f, 0f);
        Vector res = rot.apply(o);
        System.out.println(res);
    }

    @Test
    void apply() {
    }
}