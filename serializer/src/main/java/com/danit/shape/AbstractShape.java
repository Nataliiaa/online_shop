package com.danit.shape;

public abstract class AbstractShape implements Shape {
    public String getType() {
        return this.getClass().getCanonicalName();
    }
}
