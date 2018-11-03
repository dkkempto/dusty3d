package com.dusty3d.loader;

public class NotAFileException extends Exception {
    public NotAFileException() {
        super("The File object passed to the method was not a valid file.");
    }
}
