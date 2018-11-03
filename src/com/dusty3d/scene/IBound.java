package com.dusty3d.scene;

import com.dusty3d.math.Ray;

public interface IBound {
    IEntity getBoundingVolume();
    boolean intersectsBoundingVolume(Ray r);
}
