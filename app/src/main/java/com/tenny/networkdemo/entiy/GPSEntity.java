package com.tenny.networkdemo.entiy;

/**
 * Created by TennyQ on 12/23/20
 */
public class GPSEntity {

    private String Lat;

    private String Lng;

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    @Override
    public String toString() {
        return "GPSEntity{" +
                "Lat='" + Lat + '\'' +
                ", Lng='" + Lng + '\'' +
                '}';
    }
}
