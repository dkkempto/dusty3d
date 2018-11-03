package com.dusty3d.math;

public interface IIntersectable {
    Intersection getIntersection(Ray r);
}
