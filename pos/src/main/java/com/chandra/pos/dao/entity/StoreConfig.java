package com.chandra.pos.dao.entity;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class StoreConfig {


    private String storeName;

    private String storeAddress;
    private String storePhone;
    private String storeCurrency;
    private String storeEmail;
    private String dateFormat;

    public String getStoreAddress() {
        return this.storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return this.storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getStoreCurrency() {
        return this.storeCurrency;
    }

    public void setStoreCurrency(String storeCurrency) {
        this.storeCurrency = storeCurrency;
    }

    public String getStoreEmail() {
        return this.storeEmail;
    }

    public void setStoreEmail(String storeEmail) {
        this.storeEmail = storeEmail;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
