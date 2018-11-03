package com.dusty3d.math;

public class MatrixSizeMismatchException extends Exception {
    public MatrixSizeMismatchException() {
        super("The given matrices cannot be multiplied.");
    }
}
