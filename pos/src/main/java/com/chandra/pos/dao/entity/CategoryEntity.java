package com.chandra.pos.dao.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/29/12
 * Time: 10:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue
    private long id;


    private String name;

    private String description;

    @Column(name = "PARENT_ID")
    private long parentId;

    public CategoryEntity() {

    }

    public CategoryEntity(long category) {
        this.id = category;
    }

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

    @Column(name = "NAME", unique = false, nullable = true, updatable = true, insertable = true, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }
}
