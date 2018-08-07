package com.adj.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 品牌下系列
 * Created by dhx on 2018/8/7.
 */
@Entity
public class CarSerial {
    @Id
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    public CarSerial(){}

    public CarSerial(long id, String name, CarBrand carBrand) {
        this.id = id;
        this.name = name;
        this.carBrand = carBrand;
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

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }
}
