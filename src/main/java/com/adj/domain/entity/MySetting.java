package com.adj.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dhx on 2018/8/7.
 */
@Entity
public class MySetting {
    @Id
    private String myId;
    private String value;

    public String getMyId() {
        return myId;
    }

    public void setMyId(String id) {
        this.myId = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MySetting{" +
                "myId='" + myId + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
