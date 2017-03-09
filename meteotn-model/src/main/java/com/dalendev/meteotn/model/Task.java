package com.dalendev.meteotn.model;

/**
 * @author daniele.orler
 */
public class Task {

    private final Type type;
    private final String url;

    public Task(Type type, String url) {
        this.type = type;
        this.url = url;
    }

    public Type getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public enum Type {
        READ_STATION_DATA,
        UPDATE_STATION_LIST
    }
}
