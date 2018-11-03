package com.dusty3d.math;

import java.util.Arrays;

public class Matrix {
    private int rows;
    private int cols;
    private float[][] m;

    public Matrix(float[][] values) {
        rows = values.length;
        cols = values[0].length;
        m = values;
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        m = new float[rows][cols];
    }

    public static Matrix identity(int size) {
        Matrix res = new Matrix(size, size);
        for(int i = 0; i < size; i++) {
            res.m[i][i] = 1;
        }
        return res;
    }

    public float getVal(int row, int col) {
        return m[row][col];
    }

    public void setVal(int row, int col, float val) {
        m[row][col] = val;
    }

    public Matrix multiply(Matrix m2) {
        Matrix res = null;
        try {
            if(this.cols != m2.rows) throw new MatrixSizeMismatchException();
            res = new Matrix(this.rows, m2.cols);
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < m2.cols; j++) {
                    float s = 0;
                    for(int k = 0; k < this.cols; k++){
                        s += this.m[i][k]*m2.m[k][j];
                    }
                    res.m[i][j] = s;
                }
            }
        } catch(Exception e) { e.printStackTrace(); }
        return res;
    }

    public Vector multiply(Vector v) {
        Vector res = null;
        try {
            if(this.rows != 3) throw new MatrixSizeMismatchException();
            if(this.cols != 3) throw new MatrixSizeMismatchException();

            float x = m[0][0] * v.getX() +
                      m[0][1] * v.getY() +
                      m[0][2] * v.getZ();

            float y = m[1][0] * v.getX() +
                      m[1][1] * v.getY() +
                      m[1][2] * v.getZ();

            float z = m[2][0] * v.getX() +
                      m[2][1] * v.getY() +
                      m[2][2] * v.getZ();

            res = new Vector(x, y, z);
        } catch(Exception e) { e.printStackTrace(); }
        return res;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(m);
    }
}
