package com.tenny.networkdemo.entiy;

/**
 * Created by TennyQ on 12/23/20
 */
public class GPSResponse {

    private GPSEntity GPS;

    public GPSEntity getGPS() {
        return GPS;
    }

    public void setGPS(GPSEntity GPS) {
        this.GPS = GPS;
    }

    @Override
    public String toString() {
        return "GPSResponse{" +
                "GPS=" + GPS +
                '}';
    }
}
