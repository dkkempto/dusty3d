package com.dusty3d.math;

/**
 * I'm now questioning if this was the best way to structure this class.
 */
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

    public Rotation aboutAxis(Vector axis, float theta) {
        //Thank you wikipedia for blessing me with this beautiful rotation matrix
        float u = axis.getX();
        float v = axis.getY();
        float w = axis.getZ();
        float cosTheta = (float)Math.cos(theta);
        float sinTheta = (float)Math.sin(theta);
        float d = 1 - cosTheta;

        Matrix newM = m.multiply(new Matrix(new float[][] {
                {
                    u*u*d + cosTheta,
                    v*u*d - w*sinTheta,
                    w*u*d + v*sinTheta
                },
                {
                    u*v*d + w*sinTheta,
                    v*v*d + cosTheta,
                    w*v*d - u*sinTheta
                },
                {
                    u*w*d - v*sinTheta,
                    v*w*d + u*sinTheta,
                    w*w*d + cosTheta
                }
        }));

        return new Rotation(newM);
    }

    public Vector apply(Vector v){
        return m.multiply(v);
    }

    public Matrix getMatrix() { return m; }
}
