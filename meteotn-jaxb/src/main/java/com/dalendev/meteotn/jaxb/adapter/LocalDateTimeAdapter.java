package com.dalendev.meteotn.jaxb.adapter;

import java.time.LocalDateTime;

/**
 * @author daniele.orler
 */
public class LocalDateTimeAdapter {

    public static LocalDateTime unmarshal(String v) {
        return LocalDateTime.parse(v);
    }

    public static String marshal(LocalDateTime v) {
        return v.toString();
    }

}
