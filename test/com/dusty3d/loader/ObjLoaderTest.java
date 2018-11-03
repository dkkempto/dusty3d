package com.dusty3d.loader;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ObjLoaderTest {

    @Test
    void load() {
        ILoader loader = LoaderFactory.GetLoader(new File("C:\\Users\\dkemp\\Desktop\\bunny.obj"));
        loader.load();
    }
}