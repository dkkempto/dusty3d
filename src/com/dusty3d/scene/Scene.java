package com.dusty3d.scene;

import com.dusty3d.math.Vector;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private List<IEntity> entities;
    private List<Camera> cameras;
    private Camera currentCamera;

    public Scene() {
        entities = new ArrayList<>();
        cameras = new ArrayList<>();
        entities.add(new Sphere(0.1f, new Vector(0, 10, 0)));
        entities.add(new Sphere(1f, new Vector(0, 10, 1)));
        currentCamera = new Camera();
        cameras.add(currentCamera);
    }

    public List<IEntity> getEntities() {
        return entities;
    }

    public Camera getCurrentCamera() {
        return currentCamera;
    }

    public void update() {
        cameras.forEach(Camera::update);
        entities.forEach(IEntity::update);
    }


}
