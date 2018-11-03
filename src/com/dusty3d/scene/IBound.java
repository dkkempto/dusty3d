package com.dusty3d.scene;

import com.dusty3d.math.Ray;

public interface IBound {
    public IEntity getBoundingVolume();
    public boolean intersectsBoundingVolume(Ray r);
}
