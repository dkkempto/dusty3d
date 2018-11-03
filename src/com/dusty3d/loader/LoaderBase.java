package com.dusty3d.loader;

import java.io.File;

public abstract class LoaderBase implements ILoader {
    protected File file;

    public LoaderBase(File file) {
        this.file = file;
    }


}
