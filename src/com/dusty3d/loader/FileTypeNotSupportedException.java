package com.dusty3d.loader;

class FileTypeNotSupportedException extends Exception {
    public FileTypeNotSupportedException(String fileType) {
        super("File type: ." + fileType + " not supported.");
    }
}
