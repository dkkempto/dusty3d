package com.dusty3d.loader;

public class FileTypeNotSupportedException extends Exception {
    public FileTypeNotSupportedException(String fileType) {
        super("Filetype: ." + fileType + " not supported.");
    }
}
