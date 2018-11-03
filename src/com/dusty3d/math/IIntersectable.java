package com.dusty3d.math;

public interface IIntersectable {
    public Intersection getIntersection(Ray r);

    /**
     * To be used in cases where we don't care about where the intersection occurs
     * @param r
     * @return
     */
    public boolean doesIntersect(Ray r);
}
