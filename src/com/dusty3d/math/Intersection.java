package com.dusty3d.math;

public class Intersection {
    /**
     * The object that was hit. Useful if we're testing an intersection with an acceleration structure.
     */
    private IIntersectable obj;
    private Vector intersect;
    private boolean hit;
    private float t;

    public Intersection(IIntersectable obj, Vector intersect, float t, boolean hit) {
        this.obj = obj;
        this.intersect = intersect;
        this.t = t;
        this.hit = hit;
    }

    public Intersection(boolean hit) {
        this.hit = hit;
    }

    public boolean didHit() {
        return hit;
    }
}
