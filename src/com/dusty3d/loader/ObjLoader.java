package com.dusty3d.loader;

import com.dusty3d.math.Intersection;
import com.dusty3d.math.Vector;
import com.dusty3d.scene.IEntity;
import com.dusty3d.scene.Triangle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ObjLoader extends LoaderBase {

    private List<Vector> vertices;
    private List<IEntity> triangles;

    public ObjLoader(File file) {
        super(file);
    }

    @Override
    public List<IEntity> load() {
        vertices = new ArrayList<>();
        triangles = new ArrayList<>();

        try {
            Files.lines(file.toPath()).forEach(line -> {
                line = line.trim().toLowerCase();

                String[] tokens = line.split("\\s+");
                if(tokens.length == 0) return;
                switch(tokens[0]) {
                    case "v":
                        parseVertex(tokens);
                        break;
                    case "f":
                        parseFace(tokens);
                        break;
                }
            });
        } catch(IOException e) {

        }
        return triangles;
    }

    private void parseVertex(String[] tokens) {
        if(tokens.length < 4) return;   //TODO: Figure out the best way to handle invalid obj files (not enough values)
        float[] tmp = new float[3];
        for(int i = 0; i < 3; i++) {
            tmp[i] = Float.valueOf(tokens[i+1]);
        }
        vertices.add(new Vector(tmp[0], tmp[1], tmp[2]));
    }

    private void parseFace(String[] tokens) {
        if(tokens.length < 4) return; //TODO: Figure out the best way to handle invalid obj file (not enough vertices)
        int[] tmp = new int[3];
        for(int i = 0; i < 3; i++) {
            String[]  indices = tokens[i+1].split("/");
            tmp[i] = Integer.valueOf(indices[0]) - 1;  //OBJ files index starting at 1, so we account for it here
        }
        triangles.add(new Triangle(
                vertices.get(tmp[0]),
                vertices.get(tmp[1]),
                vertices.get(tmp[2])
        ));
    }

}
