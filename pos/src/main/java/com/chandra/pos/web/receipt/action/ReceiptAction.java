package com.chandra.pos.web.receipt.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.dao.entity.StoreConfig;
import com.chandra.pos.service.OrderManagement;
import com.chandra.pos.service.PaymentManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/7/12
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReceiptAction extends ActionSupport {

    private long id;
    private OrderEntity orderEntity;

    private OrderManagement orderManagement;

    private PaymentManager paymentManager;

    private StoreConfig config;
    private PaymentEntity paymentEntity;

    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public String doOrderReceipt() {
        try {
            orderEntity = orderManagement.getOrder(id);
            config = orderManagement.getStoreConfig();

        } catch (EntityNotFoundException e) {
            return ERROR;
        }

        return SUCCESS;
    }

    public String doPaymentReceipt() {
        try {
            this.paymentEntity = paymentManager.getPayment(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }
        config = orderManagement.getStoreConfig();

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public StoreConfig getConfig() {
        return config;
    }

    public void setConfig(StoreConfig config) {
        this.config = config;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }
}
