package com.danit.shape;

import java.util.ArrayList;
import java.util.List;

public class Group {
    List<Shape> group = new ArrayList<>();

    public void add(Shape shape){
        this.group.add(shape);
    }

    public List<Shape> getShapes(){
        return group;
    }
}
