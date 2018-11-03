package com.dusty3d.math;

public class Intersection {
    /**
     * The object that was hit. Useful if we're testing an intersection with an acceleration structure.
     */
    private IIntersectable obj;
    private Vector intersect;
    private boolean hit;
    private float t;
    private float u;
    private float v;

    public Intersection(IIntersectable obj, Vector intersect, float t, boolean hit) {
        this(obj, intersect, t, 0,0, hit);
    }

    public Intersection(IIntersectable obj, Vector intersect, float t, float u, float v, boolean hit) {
        this.obj = obj;
        this.intersect = intersect;
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
