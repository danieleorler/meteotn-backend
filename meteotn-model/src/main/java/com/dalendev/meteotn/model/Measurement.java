package com.dalendev.meteotn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author daniele.orler
 */
public class Measurement {

    @JsonIgnore
    private Long id;
    private final String stationCode;
    private final Long timestamp;
    private Float temperature;
    private Float rain;
    private Float windVelocity;
    private Integer windDirection;
    private Integer rsg;

    public Measurement(String stationCode, Long timestamp) {
        this.stationCode = stationCode;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getRain() {
        return rain;
    }

    public void setRain(Float rain) {
        this.rain = rain;
    }

    public Float getWindVelocity() {
        return windVelocity;
    }

    public void setWindVelocity(Float windVelocity) {
        this.windVelocity = windVelocity;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public Integer getRsg() {
        return rsg;
    }

    public void setRsg(Integer rsg) {
        this.rsg = rsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (stationCode != null ? !stationCode.equals(that.stationCode) : that.stationCode != null) return false;
        return timestamp != null ? timestamp.equals(that.timestamp) : that.timestamp == null;
    }

    @Override
    public int hashCode() {
        int result = stationCode != null ? stationCode.hashCode() : 0;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }

    public static class Builder {

        private Measurement measurement;

        public Builder(String stationCode, Long timestamp) {
            measurement = new Measurement(stationCode, timestamp);
        }

        public Builder withTemperature(Float temperature) {
            measurement.setTemperature(temperature);
            return this;
        }

        public Builder withRain(Float rain) {
            measurement.setRain(rain);
            return this;
        }

        public Builder withWindVelocity(Float windVelocity) {
            measurement.setWindVelocity(windVelocity);
            return this;
        }

        public Builder withWindDirection(Integer windDirection) {
            measurement.setWindDirection(windDirection);
            return this;
        }

        public Builder withRsg(Integer rsg) {
            measurement.setRsg(rsg);
            return this;
        }
    }
}
