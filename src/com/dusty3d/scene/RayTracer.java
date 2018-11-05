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
                Intersection i = new Intersection(false);

                for(IEntity entity : entityList) {
                    Intersection tmp = entity.getIntersection(r);
                    if(tmp.didHit()) {
                        if(i.didHit()) {
                            if(tmp.getT() < i.getT()) i = tmp;
                        } else {
                            i = tmp;
                        }
                    }
                }
                if(i.didHit()) {
                    float cosTheta =
                            i.getNormal().dot(r.getDir())
                            / i.getNormal().length()
                            / r.getDir().length();
                    if(cosTheta < 0) cosTheta *= -1;
                    Color color = new Color(
                            (int)(255 * cosTheta),
                            0,
                            0
                    );
                    bi.setRGB(x, y, color.getRGB());
                }
            }
        }
    }
}
