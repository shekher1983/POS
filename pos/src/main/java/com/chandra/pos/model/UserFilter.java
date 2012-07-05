package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/25/12
 * Time: 11:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserFilter {


    private String nameQuery;

    private int pageSize = 100;

    private int start = 0;

    private String city;

    private String state;

    private boolean supplier;

    private String contactNumber;


    public UserFilter() {


    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public UserFilter(int start, int pageSize) {
        this.setStart(start);
        this.setPageSize(pageSize);

    }

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public String getNameQuery() {
        return nameQuery;
    }

    public void setNameQuery(String nameQuery) {
        this.nameQuery = nameQuery;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
