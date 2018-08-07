package com.adj.domain.entity;

import javax.persistence.Entity;

/**
 * 车辆类型
 */
@Entity
public class CarModel extends IdEntity{

    /**
     * 车辆类型编号
     */
    private String code;

    /**
     * 车辆类型名称
     */
    private String name;

    public CarModel() {
    }

    public CarModel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
