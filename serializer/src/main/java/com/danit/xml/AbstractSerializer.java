package com.danit.xml;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractSerializer<T> implements Serializer <T>{

    public void write(OutputStream os, Integer data){
        write(os, String.valueOf(data));
    }

    public void write(OutputStream os, String shape){
        try {
            os.write(shape.getBytes());
        } catch (IOException e) {
           throw new RuntimeException("Can not write shape to the stream.");
        }
    }

}

