package com.danit.xml;

import com.danit.shape.Square;

import java.lang.*;

import java.io.OutputStream;

public class SquareSerializer extends AbstractSerializer<Square> implements Serializer<Square> {

    @Override
    public void serialize(Square shape, OutputStream os) {
        String shapeXml = "<square x = " + shape.getX() + ", y = " + shape.getY() + " > " +
                " <side> " + shape.getSide() + "</side>" +
                "</square>";

        write(os, shapeXml);
    }
}

