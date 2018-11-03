package com.dusty3d.math;
//TODO: Maybe add "dirty" flags if certain properties are being constantly recalced. (e.g. length)

public class Vector {
    private float x, y, z;

    public Vector() {
        x = 0;
        y = 0;
        z = 0;
    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(float theta, float r) {
        //TODO: Implement polar constructor
    }

    public Vector plus(Vector v) {
        return new Vector(x + v.x, y + v.y, z + v.z);
    }

    public Vector minus(Vector v) {
        return new Vector(x - v.x, y - v.y, z - v.z);
    }

    public Vector scale(float s) {
        return new Vector( x * s, y*s, z*s);
    }

    public Vector negative() { return new Vector(-x, -y, -z); }

    public float dot(Vector v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector cross(Vector v) {
        return new Vector(
                y * v.z - z * v.y,
                z * v.x - x * v.z,
                x * v.y - y * v.x
        );
    }

    public float length() {
        return (float)Math.sqrt(x*x + y*y + z*z);
    }

    public Vector normal() {
        float l = length();

        if(l == 0) return new Vector();

        return new Vector( x / l, y / l, z / l);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "<"+x+", "+y+", "+z+">";
    }
}
