package com.chandra.pos.dao.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/7/12
 * Time: 2:32 AM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class OrderItemId implements Serializable {

    private ProductEntity product;
    private OrderEntity order;

    @ManyToOne
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @ManyToOne
    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }


}
