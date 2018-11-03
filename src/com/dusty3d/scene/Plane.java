package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

public class Plane implements IEntity {

    @Override
    public Vector getNormal(float u, float v) {
        return new Vector();
    }

    @Override
    public void update() {

    }

    @Override
    public void rotate(Rotation r) {

    }

    @Override
    public void rotate(Rotation r, Vector o) {

    }

    @Override
    public void translate(Vector v) {

    }

    @Override
    public void moveTo(Vector p) {

    }

    @Override
    public Intersection getIntersection(Ray r) {
        return null;
    }

    @Override
    public boolean doesIntersect(Ray r) {
        return false;
    }
}
