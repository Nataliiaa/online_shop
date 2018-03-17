package com.danit.xml;

import com.danit.shape.Group;
import com.danit.shape.Shape;

import java.io.OutputStream;

public class GroupSerializer extends AbstractSerializer<Group> implements Serializer<Group>  {


    @Override
    public void serialize(Group group, OutputStream os) {
        write(os,"<group>");
        for (Shape shape : group.getShapes()){
            XMLSerializer.getXmlSerializer().serialize(shape, os);
        }
        write(os,"</group>");
    }
}
