package com.chandra.pos.dao.entity;

import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/14/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    @DocumentId
    private long id;


    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    @Field(index = Index.NO, analyze = Analyze.YES, store = Store.NO)
    private String description;


    private CategoryEntity category;


    private int status;

    private BigDecimal salePrice;

    private BigDecimal lastPurchasePrice;

    private BigDecimal stockQuantity;

    private long lastUpdated;

    @Id
    @GeneratedValue
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @OneToOne
    @JoinColumn(name = "PRODUCT_CATEGORY_ID", unique = true, nullable = false, updatable = true, insertable = true)
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }


    @Column(name = "SALE_PRICE")
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }


    @Column(name = "LAST_PURCHASE_PRICE")
    public BigDecimal getLastPurchasePrice() {
        return lastPurchasePrice;
    }

    public void setLastPurchasePrice(BigDecimal lastPurchasePrice) {
        this.lastPurchasePrice = lastPurchasePrice;
    }

    @Column(name = "STOCK_QUANTITY")
    public BigDecimal getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(BigDecimal stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Column(name = "LAST_UPDATED")
    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


}
