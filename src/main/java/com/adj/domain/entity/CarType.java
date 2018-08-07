package com.adj.domain.entity;

import javax.persistence.*;

/**
 * 系列下类型
 * Created by dhx on 2018/8/7.
 */
@Entity
public class CarType {
    @Id
    private long id;
    private String name;
    private String prodYear; //生产年份

    @ManyToOne
    @JoinColumn(name = "car_serial_id")
    private CarSerial carSerial;

    public CarType(){}

    public CarType(long id, String name, String prodYear, CarSerial carSerial) {
        this.id = id;
        this.name = name;
        this.prodYear = prodYear;
        this.carSerial = carSerial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarSerial getCarSerial() {
        return carSerial;
    }

    public void setCarSerial(CarSerial carSerial) {
        this.carSerial = carSerial;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }
}
