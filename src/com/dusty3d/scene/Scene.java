package com.dusty3d.scene;

import com.dusty3d.math.Rotation;
import com.dusty3d.math.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Scene implements KeyListener {

    private List<IEntity> entities;
    private List<Camera> cameras;
    private Camera currentCamera;

    public Scene() {
        entities = new ArrayList<>();
        cameras = new ArrayList<>();
        entities.add(new Sphere(0.1f, new Vector(0, 10, 0)));
        entities.add(new Triangle(
                new Vector(-1,5,0),
                new Vector(0,5,1),
                new Vector(1,5,0)
        ));
        currentCamera = new Camera();
        cameras.add(currentCamera);
    }

    public List<IEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<IEntity> entities) {
        this.entities = entities;
    }

    public Camera getCurrentCamera() {
        return currentCamera;
    }

    public void update() {
        cameras.forEach(Camera::update);
        entities.forEach(IEntity::update);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        float stride = 1.0f;
        float dTheta = 0.1f;
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                currentCamera.rotate(new Rotation().aboutAxis(currentCamera.getUp().normal(), dTheta));
                break;
            case KeyEvent.VK_RIGHT:
                currentCamera.rotate(new Rotation().aboutAxis(currentCamera.getUp().normal(), -dTheta));
                break;
            case KeyEvent.VK_UP:
                currentCamera.rotate(new Rotation().aboutAxis(currentCamera.getRight().normal(), -dTheta));
                break;
            case KeyEvent.VK_DOWN:
                currentCamera.rotate(new Rotation().aboutAxis(currentCamera.getRight().normal(), dTheta));
                break;
            case KeyEvent.VK_W:
                currentCamera.translate(currentCamera.getDir().normal().scale(stride));
                break;
            case KeyEvent.VK_A:
                currentCamera.translate(currentCamera.getRight().normal().scale(-stride));
                break;
            case KeyEvent.VK_S:
                currentCamera.translate(currentCamera.getDir().normal().scale(-stride));
                break;
            case KeyEvent.VK_D:
                currentCamera.translate(currentCamera.getRight().normal().scale(stride));
                break;
            case KeyEvent.VK_SHIFT:
                currentCamera.translate(Camera.GLOBAL_UP.scale(-stride));
                break;
            case KeyEvent.VK_SPACE:
                currentCamera.translate(Camera.GLOBAL_UP.scale(stride));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
