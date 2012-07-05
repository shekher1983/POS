package com.chandra.pos.dao.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/15/12
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ORDER_ITEMS")
@AssociationOverrides({
        @AssociationOverride(name = "pk.order",
                joinColumns = @JoinColumn(name = "ORDER_ID")),
        @AssociationOverride(name = "pk.product",
                joinColumns = @JoinColumn(name = "PRODUCT_ID"))})
public class OrderItemEntity implements Serializable {

    public static int AMOUNT_PRECISION = 2;


    private OrderItemId pk = new OrderItemId();

    private BigDecimal salePrice;

    private BigDecimal quantity;

    private BigDecimal discount;
    private ProductEntity product;


    @Column(name = "PRODUCT_SALE_PRICE")
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }


    @Column(name = "ORDER_QUANTITY")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }


    @EmbeddedId
    public OrderItemId getPk() {
        return pk;
    }

    public void setPk(OrderItemId pk) {
        this.pk = pk;
    }

    @Transient
    public OrderEntity getOrder() {
        return getPk().getOrder();
    }

    @Transient
    public ProductEntity getProduct() {
        return getPk().getProduct();
    }

    public void setOrder(OrderEntity orderEntityEntity) {
        getPk().setOrder(orderEntityEntity);
    }

    public void setProduct(ProductEntity productEntity) {
        getPk().setProduct(productEntity);
    }

    @Transient
    public BigDecimal getTotalAmount() {
        BigDecimal totalAmount = new BigDecimal(0);


        BigDecimal item_amount_obj = this.getSalePrice().multiply(this.getQuantity());

        totalAmount = totalAmount.add(item_amount_obj);


        if (discount != null)
            totalAmount = totalAmount.subtract(discount);


        totalAmount = totalAmount.setScale(OrderEntity.AMOUNT_PRECISION, RoundingMode.HALF_UP);

        return totalAmount;

    }

    @Column(name = "DISCOUNT")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


}
