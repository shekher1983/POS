package com.chandra.pos.dao.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/17/12
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */

@Embeddable
public class ItemEntity implements Serializable {

    private Long productId;

    private Long orderId;


    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ItemEntity() {

    }

    public ItemEntity(Long productId, Long orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }
}
