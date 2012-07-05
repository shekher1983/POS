package com.chandra.pos.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name = "PROPERTIES")
public class PropertyEntity {


    @Id
    String key;

    String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
