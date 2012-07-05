package com.chandra.pos.model;

import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/24/12
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentFilter extends Filter {


    private CustomerEntity customer;

    private EmployeeEntity employee;

    private Date startDate;

    private Date endDate;

    private String city;

    private BigDecimal amount;
    private boolean credited;

    private PaymentType type;

    public boolean isCredited() {
        return credited;
    }

    public void setCredited(boolean credited) {
        this.credited = credited;
    }

    public PaymentFilter() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PaymentFilter(int start, int pageSize) {

        super(start, pageSize);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
