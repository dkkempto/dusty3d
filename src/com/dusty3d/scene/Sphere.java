package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

public class Sphere implements IEntity {
    private float r;
    private Vector origin;

    public Sphere() {
        this(1);
    }

    public Sphere(float r) {
        this(r, new Vector());
    }

    public Sphere(Vector origin) {
        this(1, origin);
    }

    public Sphere(float r, Vector origin) {
        this.r = r;
        this.origin = origin;
    }

    @Override
    public void update() {
        translate(new Vector(10f, 0f, 0f));
    }

    @Override
    public void rotate(Rotation r) {
        translate(origin.negative());
        origin = r.apply(origin);
        translate(origin);
    }

    @Override
    public void rotate(Rotation r, Vector o) {
        translate(o.negative());
        origin = r.apply(origin);
        translate(o);
    }

    @Override
    public void translate(Vector v) {
        origin = origin.plus(v);
    }

    @Override
    public void moveTo(Vector p) {
        origin = p;
    }

    @Override
    public Intersection getIntersection(Ray r) {
        Vector m = r.getOrigin().minus(this.origin);

        Vector P = r.getOrigin();
        Vector C = this.origin;

        Vector Q = P.minus(C);

        Vector U = r.getDir().normal();

        float a = U.dot(U);
        float b = 2 * U.dot(Q);
        float c = Q.dot(Q) - (this.r * this.r);
        float d = (b * b) - (4 * a  * c);
        if(d < 0) return new Intersection(false);

        //Quadratic formula
        float e = -b/(2*a);
        float f = (float)Math.sqrt(d)/(2f*a);
        float t1 = e + f;
        float t2 = e - f;

        Vector i = r.at(t1);

        return new Intersection(this, i, t1, true);
    }

    @Override
    public boolean doesIntersect(Ray r) {
        return false;
    }
}
