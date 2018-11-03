package com.dusty3d.math;

public class Rotation {
    private Matrix m;

    public Rotation() {
        m = Matrix.identity(3);
    }

    public Rotation(Matrix m) {
        this.m = m;
    }

    public Rotation rotateX(float theta) {
        Matrix newM = m.multiply(new Matrix(new float[][] {
                {1, 0, 0},
                {0, (float)Math.cos(theta), -(float)Math.sin(theta)},
                {0, (float)Math.sin(theta), (float)Math.cos(theta)}
        }));
        return new Rotation(newM);
    }

    public Rotation rotateY(float theta) {
        Matrix newM = m.multiply(new Matrix(new float[][] {
                {(float)Math.cos(theta), 0, (float)Math.sin(theta)},
                {0, 1, 0},
                {-(float)Math.sin(theta), 0, (float)Math.cos(theta)}
        }));
        return new Rotation(newM);
    }

    public Rotation rotateZ(float theta) {
        Matrix newM = m.multiply(new Matrix(new float[][] {
                {(float)Math.cos(theta), -(float)Math.sin(theta), 0},
                {(float)Math.sin(theta), (float)Math.cos(theta), 0},
                {0, 0, 1}
        }));
        return new Rotation(newM);
    }

    public Vector apply(Vector v){
        return m.multiply(v);
    }

    public Matrix getMatrix() { return m; }
}
