package com.dusty3d.scene;

import com.dusty3d.math.IIntersectable;
import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

public interface IEntity extends IIntersectable {
    void update();
    void rotate(Rotation r);
    void rotate(Rotation r, Vector o);
    void translate(Vector v);
    void moveTo(Vector p);
}
