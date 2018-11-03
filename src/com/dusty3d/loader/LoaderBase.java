package com.dusty3d.loader;

import java.io.File;

abstract class LoaderBase implements ILoader {
    protected File file;

    public LoaderBase(File file) {
        this.file = file;
    }


}
