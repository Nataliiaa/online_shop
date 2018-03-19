package com.danit.xml;

import com.danit.shape.Circle;
import com.danit.shape.Group;
import com.danit.shape.Shape;
import com.danit.shape.Square;
import sun.security.provider.SHA;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class XMLSerializer implements Serializer<Shape> {

    private final static XMLSerializer xmlSerializer = new XMLSerializer();

    private Map<String, Serializer> serializers = new HashMap<>();

    private XMLSerializer() {
        serializers.put(Square.class.getCanonicalName(), new SquareSerializer());
        serializers.put(Circle.class.getCanonicalName(), new CircleSerializer());
        serializers.put(Group.class.getCanonicalName(), new GroupSerializer());
    }

    public static Serializer<Shape> getXmlSerializer(){
        return xmlSerializer;
    }

    @Override
    public void serialize(Shape shape, OutputStream os) {
        Serializer serializer = serializers.get(shape.getClass().getCanonicalName());
        if (serializer != null) {
            serializer.serialize(shape, os);
        }
    }
}
