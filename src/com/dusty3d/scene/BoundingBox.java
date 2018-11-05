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
        float tmin = (min.getX() - r.getOrigin().getX()) / r.getDir().getX();
        float tmax = (max.getX() - r.getOrigin().getX()) / r.getDir().getX();

        if(tmin > tmax) {
            float tmp = tmax;
            tmax = tmin;
            tmin = tmp;
        }

        float tymin = (min.getY() - r.getOrigin().getY()) / r.getDir().getY();
        float tymax = (max.getY() - r.getOrigin().getY()) / r.getDir().getY();

        if(tymin > tymax) {
            float tmp = tymax;
            tmax = tmin;
            tmin = tmp;
        }

        if((tmin > tymax) || (tymin > tmax)) return false;

        if(tymin > tmin) tmin = tymin;

        if(tymax < tmax) tmax = tymax;

        float tzmin = (min.getZ() - r.getOrigin().getZ()) / r.getDir().getZ();
        float tzmax = (max.getZ() - r.getOrigin().getZ()) / r.getDir().getZ();

        if(tzmin > tzmax) {
            float tmp = tzmax;
            tzmax = tzmin;
            tzmin = tmp;
        }

        if((tmin > tzmax) || (tzmin > tmax)) return false;

        if(tzmin > tmin) tmin = tzmin;

        if(tzmax < tmax) tmax = tzmax;

        return true;
    }

    public Vector getMin() {
        return min;
    }

    public Vector getMax() {
        return max;
    }
}
