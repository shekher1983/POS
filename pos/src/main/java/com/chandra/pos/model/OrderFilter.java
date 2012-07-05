package com.chandra.pos.model;

import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 6/6/12
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderFilter extends Filter {


    private CustomerEntity customer;

    private EmployeeEntity employee;

    private Date startDate;

    private Date endDate;

    private OrderType orderType;

    private String city;

    private OrderStatus status;

    public OrderFilter(int start, int pageSize) {
        super(start, pageSize);
        //To change body of created methods use File | Settings | File Templates.
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}
