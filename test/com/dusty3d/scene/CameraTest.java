package com.dusty3d.scene;

import com.dusty3d.math.Ray;
import org.junit.jupiter.api.Test;

class CameraTest {

    @Test
    void getRay() {
        Camera c = new Camera();
        Ray r = c.getRay(0, 0);
        System.out.println(r);

        r = c.getRay(0, 300);
        System.out.println(r);

        r = c.getRay(400, 0);
        System.out.println(r);

        r = c.getRay(400, 300);
        System.out.println(r);
    }
}