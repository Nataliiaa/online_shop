package com.danit.xml;

import com.danit.shape.Circle;

import java.io.OutputStream;

public class CircleSerializer extends AbstractSerializer<Circle> implements Serializer<Circle> {
    @Override
    public void serialize(Circle shape, OutputStream os) {
        write(os, "<circle>");
        write(os, "<x>");
        write(os, shape.getX());
        write(os, "</x><y>");
        write(os, shape.getY());
        write(os, "</y><radius>");
        write(os, shape.getRadius());
        write(os, "</radius>");
        write(os, "</circle>");
    }
}
