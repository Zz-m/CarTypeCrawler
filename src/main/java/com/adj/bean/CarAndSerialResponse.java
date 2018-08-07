package com.adj.bean;

import java.util.List;

/**
 * Created by dhx on 2018/8/7.
 */
public class CarAndSerialResponse {

    private long Count;
    private long CarNumber;

    private List<CarSerialResponse> ResList;

    public long getCount() {
        return Count;
    }

    public void setCount(long count) {
        Count = count;
    }

    public long getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(long carNumber) {
        CarNumber = carNumber;
    }

    public List<CarSerialResponse> getResList() {
        return ResList;
    }

    public void setResList(List<CarSerialResponse> resList) {
        ResList = resList;
    }
}
