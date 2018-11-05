package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

import java.util.List;

public class Mesh implements IEntity, IBound {

    private BoundingBox bb;
    private KDNode kdTree;

    private List<Triangle> triangles;

    public Mesh(List<Triangle> triangles) {
        this.triangles = triangles;
        bb = new BoundingBox(triangles);
        kdTree = new KDNode(triangles);
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
    public IEntity getBoundingBox() {
        return bb;
    }

    @Override
    public boolean intersectsBoundingBox(Ray r) {
        return false;
    }

    @Override
    public Intersection getIntersection(Ray r) {
        return kdTree.getIntersection(r);
    }

}
