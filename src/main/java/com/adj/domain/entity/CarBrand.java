package com.adj.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dhx on 2018/8/7.
 */
@Entity
public class CarBrand {
    @Id
    private long id;
    private String code;
    private String name;

    public CarBrand(){}

    public CarBrand(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
