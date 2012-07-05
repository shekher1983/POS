package com.chandra.pos.dao.entity;

import com.chandra.pos.model.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/10/12
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ORDER_PAYMENTS")
public class OrderPaymentEntity {

    private long id;
    private BigDecimal amount;

    private PaymentType type;

    private long orderId;

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "PAYMENT_TYPE_ID")
    @Enumerated(EnumType.ORDINAL)
    public PaymentType getType() {
        return type;
    }


    public void setType(PaymentType type) {
        this.type = type;
    }

    @Column(name = "PAYMENT_AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Column(name = "ORDER_ID")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
