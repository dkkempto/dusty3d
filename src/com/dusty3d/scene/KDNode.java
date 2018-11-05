package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;

import java.math.RoundingMode;
import java.util.List;

public class KDNode {
    KDNode left, right;
    List<Triangle> triangles;
    BoundingBox bb;
    int depth;
    Axis axis;
    boolean isLeaf;

    public KDNode(List<Triangle> tris) {
        depth = 0;
        axis = Axis.X;
        bb = new BoundingBox(tris);
        triangles = tris;

        if(tris.size() > 3) {
            sortByAxis();
            int i = getSplittingIndex();
            List<Triangle> l = tris.subList(0, i);
            List<Triangle> r = tris.subList(i, tris.size());
            left = new KDNode(l, depth + 1);
            right = new KDNode(r, depth + 1);
        } else {
            isLeaf = true;
        }
    }

    private KDNode(List<Triangle> tris, int depth) {
        this.depth = depth;
        int a = depth % 3;
        if(a == 0) axis = Axis.X;
        if(a == 1) axis = Axis.Y;
        if(a == 2) axis = Axis.Z;
        bb = new BoundingBox(tris);
        triangles = tris;

        if(tris.size() > 3) {
            sortByAxis();
            int i = getSplittingIndex();
            List<Triangle> l = tris.subList(0, i);
            List<Triangle> r = tris.subList(i, tris.size());
            left = new KDNode(l, depth + 1);
            right = new KDNode(r, depth + 1);
        } else {
            isLeaf = true;
        }
    }

    /**
     * Recurse down the tree and test for intersections.
     * @param r The ray to test against
     * @return An intersection object containing all relevant data
     */
    public Intersection getIntersection(Ray r) {
        Intersection res = new Intersection(false);

        if(isLeaf) {
            //Loop through the triangles, test intersection and keep the closest
            for(Triangle t : triangles) {
                Intersection tmp = t.getIntersection(r);
                if(res.didHit()) {
                    if(tmp.didHit() && tmp.getT() < res.getT()) {
                        res = tmp;
                    }
                } else {
                    res = tmp;
                }
            }
        } else {
            if(left.bb.doesIntersect(r)) {
                Intersection tmp = left.getIntersection(r);
                if(res.didHit()) {
                    if(tmp.didHit() && tmp.getT() < res.getT()) {
                        res = tmp;
                    }
                } else {
                    res = tmp;
                }
            }

            if(right.bb.doesIntersect(r)) {
                Intersection tmp = right.getIntersection(r);
                if(res.didHit()) {
                    if(tmp.didHit() && tmp.getT() < res.getT()) {
                        res = tmp;
                    }
                } else {
                    res = tmp;
                }
            }
        }
        return res;
    }

    private void sortByAxis() {
        switch(axis) {
            case X:
                triangles.sort(Triangle.XAxisComparator);
                break;
            case Y:
                triangles.sort(Triangle.YAxisComparator);
                break;
            case Z:
                triangles.sort(Triangle.ZAxisComparator);
                break;
        }
    }

    private int getSplittingIndex() {
        //TODO: Probably come up with a better splitting method.
        //For now we're just going to sort by whatever axis this node is on
        //and then split the list directly in half.
        //In the future possibly look into the surface area heuristic,
        //it seems to be all the rage in the ray tracing community.

        return triangles.size() / 2;
    }

    public enum Axis {
        X, Y, Z
    }
}

