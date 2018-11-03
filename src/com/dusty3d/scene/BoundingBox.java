package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

import java.util.List;

public class BoundingBox implements IEntity {

    private Vector min, max;

    public BoundingBox() {
        min = new Vector();
        max = new Vector();
    }

    public BoundingBox(Triangle t) {
        min = new Vector();
        max = new Vector();
        expand(t);
    }

    public BoundingBox(List<Triangle> triangles) {
        min = new Vector();
        max = new Vector();
        triangles.forEach(triangle -> {
            expand(triangle);
        });
    }

    public void expand(BoundingBox bb) {
        expand(bb.min);
        expand(bb.max);
    }

    public void expand(Triangle t) {
        expand(t.getP0());
        expand(t.getP1());
        expand(t.getP2());
    }

    public void expand(Vector v) {
        min = new Vector(
                Math.min(v.getX(), min.getX()),
                Math.min(v.getY(), min.getY()),
                Math.min(v.getZ(), min.getZ())
        );

        max = new Vector(
                Math.max(v.getX(), max.getX()),
                Math.max(v.getY(), max.getY()),
                Math.max(v.getZ(), max.getZ())
        );
    }

    @Override
    public Vector getNormal(float u, float v) {
        return null;
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

    public boolean doesIntersect(Ray r) {
        return false;
    }
}
