package com.dusty3d.loader;

import java.io.File;

public class LoaderFactory {
    public static final String FILE_TYPE_OBJ = "obj";

    public ILoader GetLoader(String path) {
        return GetLoader(new File(path));
    }

    public static ILoader GetLoader(File f) {
        String ext;
        ILoader res = null;

        try {
            if(f == null) throw new NotAFileException();
            if(!f.isFile()) throw new NotAFileException();

            int index = f.getName().lastIndexOf(".");
            ext = f.getName().substring(index + 1);
            System.out.println(ext);
            switch (ext.toLowerCase()) {
                case FILE_TYPE_OBJ:
                    res = new ObjLoader(f);
                    break;
                default:
                    throw new FileTypeNotSupportedException(ext.toLowerCase());
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }
}
