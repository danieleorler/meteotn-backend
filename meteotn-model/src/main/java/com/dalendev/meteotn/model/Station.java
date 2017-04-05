package com.dalendev.meteotn.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author daniele.orler
 */
@Entity
@Table(name = "station")
public class Station {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private final String code;
    private String name;
    private String shortName;
    private Integer altitude;
    private Float latitude;
    private Float longitude;
    private LocalDate activeFrom;
    private LocalDate activeUntil;
    private LocalDateTime lastUpdate;

    public Station(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }

    public LocalDate getActiveUntil() {
        return activeUntil;
    }

    public void setActiveUntil(LocalDate activeUntil) {
        this.activeUntil = activeUntil;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station station = (Station) o;

        return getCode().equals(station.getCode());
    }

    @Override
    public int hashCode() {
        return getCode().hashCode();
    }

    public static class Builder {

        private Station station;

        public Builder(String code) {
            station = new Station(code);
        }

        public Builder withName(String name) {
            station.setName(name);
            return this;
        }

        public Builder withShortName(String shortName) {
            station.setShortName(shortName);
            return this;
        }

        public Builder withAltitude(Integer altitude) {
            station.setAltitude(altitude);
            return this;
        }

        public Builder withLatitude(Float latitude) {
            station.setLatitude(latitude);
            return this;
        }

        public Builder withLongitude(Float longitude) {
            station.setLongitude(longitude);
            return this;
        }

        public Builder withActiveFrom(LocalDate from) {
            station.setActiveFrom(from);
            return this;
        }

        public Builder withActiveUntil(LocalDate to) {
            station.setActiveUntil(to);
            return this;
        }

        public Station build() {
            return station;
        }
    }

}
