package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

public class Triangle implements IEntity {
    /** Used in calculating the intersection of a triangle with a ray */
    private final float EPSILON = 0.0000001f;

    private Vector p0;
    private Vector p1;
    private Vector p2;

    public Triangle() {
        this(new Vector(-1, 0, 0), new Vector(0, 0, 1), new Vector(1, 0, 0));
    }

    public Triangle(Vector p1, Vector p2, Vector p3) {
        this.p0 = p1;
        this.p1 = p2;
        this.p2 = p3;
    }

    @Override
    public void update() {

    }

    @Override
    public void rotate(Rotation r) {
        r.apply(p0);
        r.apply(p1);
        r.apply(p2);
    }

    @Override
    public void rotate(Rotation r, Vector o) {
        translate(o.negative());
        rotate(r);
        translate(o);
    }

    @Override
    public void translate(Vector v) {
        p0 = p0.plus(v);
        p1 = p1.plus(v);
        p2 = p2.plus(v);
    }

    @Override
    public void moveTo(Vector p) {
        Vector delta = p.minus(p0);
        p0 = p0.plus(delta);
        p1 = p1.plus(delta);
        p2 = p2.plus(delta);
    }

    @Override
    public Intersection getIntersection(Ray r) {
        Vector edge1 = p1.minus(p0);
        Vector edge2 = p2.minus(p0);
        Vector h = r.getDir().cross(edge2);
        float a = edge1.dot(h);
        if(a > -EPSILON && a < EPSILON)
            return new Intersection(false);

        float f = 1.0f / a;
        Vector s = r.getOrigin().minus(p0);
        float u = f * s.dot(h);
        if(u < 0f || u > 1f) return new Intersection(false);

        Vector q = s.cross(edge1);
        float v = f * r.getDir().dot(q);
        if(v < 0f || (u + v) > 1) return new Intersection(false);

        float t = f * edge2.dot(q);

        if(t > EPSILON) {
            Vector intersect = r.at(t);
            return new Intersection(this, intersect, t, u, v, true);
        }

        return new Intersection(false);
    }

    @Override
    public boolean doesIntersect(Ray r) {
        return false;
    }

    public Vector getP0() {
        return p0;
    }

    public Vector getP1() {
        return p1;
    }

    public Vector getP2() {
        return p2;
    }
}
