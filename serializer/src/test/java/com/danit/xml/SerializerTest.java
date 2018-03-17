package com.danit.xml;

import com.danit.shape.Circle;
import com.danit.shape.Shape;
import com.danit.shape.Square;
import com.sun.xml.internal.txw2.output.XmlSerializer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SerializerTest {


    @Test
    public void test(){
        Shape square = new Square(0, 2, 3);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XMLSerializer.getXmlSerializer().serialize(square, outputStream);

        System.out.println(new String(outputStream.toByteArray()));
    }

    @Test
    public void verifyThatCircleCanBeSerializedToXml() {
        // given
        Circle circle = new Circle(100, 100, 200);
        Serializer serializer = XMLSerializer.getXmlSerializer();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // when
        serializer.serialize(circle, out);

        // then
        assertThat(out.toString(), is("<circle><x>100</x><y>100</y><radius>200</radius></circle>"));
    }

}