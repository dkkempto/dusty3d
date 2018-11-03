package com.dusty3d.loader;

import com.dusty3d.scene.IEntity;

import java.io.File;
import java.util.List;

public class ObjLoader extends LoaderBase {

    public ObjLoader(File file) {
        super(file);
    }

    @Override
    public List<IEntity> load() {
        //TODO: Implement a load for obj files.
        return null;
    }

}
