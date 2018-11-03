package com.dusty3d.scene;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Ray;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class RayTracer implements IRenderer {
    @Override
    public void render(BufferedImage bi, Scene s) {
        for(int x = 0; x < bi.getWidth(); x++) {
            for(int y = 0; y < bi.getHeight(); y++) {
                List<IEntity> entityList = s.getEntities();
                Camera c = s.getCurrentCamera();
                Ray r = c.getRay(x, y);
                for(IEntity entity : entityList) {
                    Intersection i = entity.getIntersection(r);
                    if(i.didHit()) {
                        Color color = new Color(
                                (int)(i.getU()*255),
                                (int)(i.getV()*255),
                                128
                        );
                        bi.setRGB(x, y, color.getRGB());
                    }
                }
            }
        }
    }
}
