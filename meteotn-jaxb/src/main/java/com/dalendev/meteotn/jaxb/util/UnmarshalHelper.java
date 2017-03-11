package com.dalendev.meteotn.jaxb.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author daniele.orler
 */
public class UnmarshalHelper {

    public static <T> T unmarshal(File file, Class<T> target) throws JAXBException, IOException {
        return UnmarshalHelper.unmarshal(new FileInputStream(file), target);
    }

    public static <T> T unmarshal(URL url, Class<T> target) throws JAXBException, IOException {
        return UnmarshalHelper.unmarshal(url.openStream(), target);
    }

    public static <T> T unmarshal(InputStream source, Class<T> target) throws JAXBException, IOException {

        Unmarshaller unmarshaller = JAXBContext
                .newInstance(target)
                .createUnmarshaller();

        StreamSource src = new StreamSource(source);
        JAXBElement jaxbElement = unmarshaller.unmarshal(src, target);

        return (T) jaxbElement.getValue();
    }
}
