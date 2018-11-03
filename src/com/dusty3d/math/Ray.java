package com.dusty3d.math;

public class Ray {
    private Vector origin;
    private Vector dir;

    public Ray(Vector origin, Vector dir) {
        this.origin = origin;
        this.dir = dir;
    }

    public Vector at(float t) {
        return dir.scale(t).plus(origin);
    }

    public Intersection intersect(IIntersectable obj) {
        return obj.getIntersection(this);
    }

    public Vector getOrigin() {
        return origin;
    }

    public Vector getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return "Origin: "+origin.toString()+" Dir: "+dir.toString();
    }
}
