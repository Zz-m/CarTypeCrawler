package com.adj.bean;

/**
 * Created by dhx on 2018/8/7.
 */
public class CarResponse {
    private long CarID;
    private String CarName;
    private String CarYear;

    public long getCarID() {
        return CarID;
    }

    public void setCarID(long carID) {
        CarID = carID;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarYear() {
        return CarYear;
    }

    public void setCarYear(String carYear) {
        CarYear = carYear;
    }
}
