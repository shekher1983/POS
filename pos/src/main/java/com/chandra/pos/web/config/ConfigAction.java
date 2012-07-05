package com.chandra.pos.web.config;

import com.chandra.pos.dao.entity.StoreConfig;
import com.chandra.pos.service.OrderManagement;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConfigAction extends ActionSupport {
    private OrderManagement orderManagement;
    private String storeName;

    private String storeAddress;
    private String storePhone;
    private String storeCurrency;
    private String storeEmail;
    private String dateFormat;


    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public String execute() throws Exception {
        StoreConfig config = orderManagement.getStoreConfig();
        storeName = config.getStoreName();
        storeAddress = config.getStoreAddress();
        storePhone = config.getStorePhone();
        storeCurrency = config.getStoreCurrency();
        storeEmail = config.getStoreEmail();
        dateFormat = config.getDateFormat();
        return SUCCESS;
    }

    public String doUpdate() throws Exception {
        StoreConfig config = orderManagement.getStoreConfig();
        config.setStoreName(storeName);
        config.setStoreAddress(storeAddress);
        config.setStorePhone(storePhone);
        config.setStoreCurrency(storeCurrency);
        config.setStoreEmail(storeEmail);
        config.setDateFormat(dateFormat);

        return INPUT;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreCurrency() {
        return storeCurrency;
    }

    public void setStoreCurrency(String storeCurrency) {
        this.storeCurrency = storeCurrency;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
