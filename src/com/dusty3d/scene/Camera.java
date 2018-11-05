package com.dusty3d.scene;

import com.dusty3d.main.Screen;
import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

public class Camera implements IEntity {
    public static final Vector GLOBAL_UP = new Vector(0, 0, 1);
    private static final float NEAR_PLANE_DISTANCE = 1f;
    private static final float FOV = (float)Math.PI / 3.0f;
    private static final float ASPECT_RATIO = (float)Screen.WIDTH / (float)Screen.HEIGHT;

    private static final float WIDTH_HALF = (float)Math.tan(FOV) * NEAR_PLANE_DISTANCE;
    private static final float HEIGHT_HALF = WIDTH_HALF / ASPECT_RATIO;

    private Vector loc;
    private Vector dir;
    private Vector right;
    private Vector up;


    public Camera() {
        loc = new Vector();
        dir = new Vector(0, 1, 0);
        calculateOtherDirectionVectors();
    }

    private void calculateOtherDirectionVectors() {
        right = dir.cross(GLOBAL_UP).normal().scale(WIDTH_HALF);
        up = right.cross(dir).normal().scale(HEIGHT_HALF);
    }

    public Ray getRay(int x, int y) {
        float tx = ((float)x / (float)Screen.WIDTH) - 0.5f;
        float ty = (((float)y / (float)Screen.HEIGHT) - 0.5f);

        Vector rayDir = dir.scale(NEAR_PLANE_DISTANCE)
                .plus(right.scale(tx))
                .plus(up.scale(ty));

        return new Ray(loc, rayDir);
    }

    @Override
    public void update() {
        //rotate(new Rotation().rotateZ((float)Math.PI/80));
        //translate(new Vector(0f, 0.1f, 0f));
    }

    public void lookAt(Vector v) {
        dir = v.minus(loc).normal();
    }

    @Override
    public void rotate(Rotation r) {
        dir = r.apply(dir).normal();
        calculateOtherDirectionVectors();
    }

    @Override
    public void rotate(Rotation r, Vector o) {
        translate(o.negative());
        loc = r.apply(loc);
        dir = r.apply(dir);
        translate(o);
        calculateOtherDirectionVectors();
    }

    @Override
    public void translate(Vector v) {
        loc = loc.plus(v);
        calculateOtherDirectionVectors();
    }

    @Override
    public void moveTo(Vector p) {

    }

    @Override
    public Intersection getIntersection(Ray r) {
        return null;
    }

    public Vector getLoc() {
        return loc;
    }

    public Vector getDir() {
        return dir;
    }

    public Vector getRight() {
        return right;
    }

    public Vector getUp() {
        return up;
    }

}
