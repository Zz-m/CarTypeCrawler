package com.adj.bean;

/**
 * Created by dhx on 2018/8/7.
 */
public class CarSerialResponse {
    private int MasterId;
    private long SerialId;
    private String ShowName;
    private String CarIdList;

    public int getMasterId() {
        return MasterId;
    }

    public void setMasterId(int masterId) {
        MasterId = masterId;
    }

    public long getSerialId() {
        return SerialId;
    }

    public void setSerialId(long serialId) {
        SerialId = serialId;
    }

    public String getShowName() {
        return ShowName;
    }

    public void setShowName(String showName) {
        ShowName = showName;
    }

    public String getCarIdList() {
        return CarIdList;
    }

    public void setCarIdList(String carIdList) {
        CarIdList = carIdList;
    }
}
