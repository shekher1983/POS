package com.chandra.pos.dao.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/18/12
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "STATUS")

public class StatusEntity {


    @Id
    @GeneratedValue
    private long id;


    private String name;

    private String description;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME", unique = true, updatable = true, insertable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
