package com.danit.xml;

import java.io.OutputStream;

public interface Serializer <T> {

    void serialize (T shape, OutputStream os);

}
