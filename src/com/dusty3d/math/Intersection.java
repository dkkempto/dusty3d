package com.dusty3d.math;

public class Intersection {
    /**
     * The object that was hit. Useful if we're testing an intersection with an acceleration structure.
     */
    private IIntersectable obj;
    private Vector intersect;
    private Vector normal;
    private boolean hit;
    private float t;
    private float u;
    private float v;

    public Intersection(IIntersectable obj, Vector intersect, Vector normal, float t, boolean hit) {
        this(obj, intersect, normal, t, 0,0, hit);
    }

    public Intersection(IIntersectable obj, Vector intersect, Vector normal, float t, float u, float v, boolean hit) {
        this.obj = obj;
        this.intersect = intersect;
        this.normal = normal;
        this.t = t;
        this.u = u;
        this.v = v;
        this.hit = hit;
    }

    public Intersection(boolean hit) {
        this.hit = hit;
    }

    public boolean didHit() {
        return hit;
    }

    public IIntersectable getObj() {
        return obj;
    }

    public Vector getIntersect() {
        return intersect;
    }

    public Vector getNormal() {
        return normal;
    }

    public float getT() {
        return t;
    }

    public float getU() {
        return u;
    }

    public float getV() {
        return v;
    }

}
