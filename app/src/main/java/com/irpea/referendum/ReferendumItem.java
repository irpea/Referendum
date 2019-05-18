package com.irpea.referendum;

import java.util.UUID;

public class ReferendumItem {
    private String mCountyName;
    private String mCaption;
    private UUID mId;
    private int mCounty;
    private double mLat;
    private double mLon;

    public ReferendumItem(){
        mId = UUID.randomUUID();
    }

    public String getCountyName() {
        return mCountyName;
    }

    public void setCountyName(String countyName) {
        mCountyName = countyName;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public UUID getId() {
        return mId;
    }

    public int getCounty() {
        return mCounty;
    }

    public void setCounty(int county) {
        mCounty = county;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        mLon = lon;
    }


}
