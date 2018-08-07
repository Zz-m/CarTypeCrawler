package com.adj.bean;

import java.util.List;

/**
 * Created by dhx on 2018/8/7.
 */
public class CarQueryResponse {
    private long MaxPv;

    private List<CarResponse> CarList;

    public long getMaxPv() {
        return MaxPv;
    }

    public void setMaxPv(long maxPv) {
        MaxPv = maxPv;
    }

    public List<CarResponse> getCarList() {
        return CarList;
    }

    public void setCarList(List<CarResponse> carList) {
        CarList = carList;
    }
}
