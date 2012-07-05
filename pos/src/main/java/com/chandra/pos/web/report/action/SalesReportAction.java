package com.chandra.pos.web.report.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.model.PaymentFilter;
import com.chandra.pos.model.PaymentType;
import com.chandra.pos.service.OrderManagement;
import com.chandra.pos.service.PaymentManager;
import com.chandra.pos.service.UserManagement;
import com.opensymphony.xwork2.ActionSupport;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/22/12
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class SalesReportAction extends ActionSupport {


    private OrderManagement orderManagement;

    private PaymentManager paymentManager;

    private UserManagement userManagement;


    private long customerId;

    private CustomerEntity customer;


    private List<PaymentEntity> paymentEntities;

    private List<OrderEntity> orderEntities;


    public List<PaymentEntity> getPaymentEntities() {
        return paymentEntities;
    }

    public void setPaymentEntities(List<PaymentEntity> paymentEntities) {
        this.paymentEntities = paymentEntities;
    }

    public List<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public String doList() {

        return SUCCESS;
    }

    public String doListOrders() {
        Date startDateParam = null, endDatePram = null;


        if (dateFilterType == 0) {
            if (dateRange == 0) {//today
                DateTime date = new DateTime().toDateMidnight().toDateTime();
                DateTime tomorrow = date.plusDays(1);

                startDateParam = date.toDate();
                endDatePram = tomorrow.toDate();
            } else if (dateRange == 1) {//yesterday
                DateTime date = new DateTime().toDateMidnight().toDateTime().minus(1);
                DateTime yesterday = date.minusDays(1).plus(1);

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 2) {//last 7 days
                DateTime date = new DateTime();
                DateTime yesterday = date.minusDays(7).toDateMidnight().toDateTime();

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 3) {//this month
                DateTime date = new DateTime();
                int dayOfMonth = date.dayOfMonth().get();
                DateTime yesterday = date.minusDays(dayOfMonth - 1).toDateMidnight().toDateTime();

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 4) {//last month
                DateTime date = new DateTime().toDateMidnight().toDateTime();
                int dayOfMonth = date.dayOfMonth().get();
                DateTime lastMonth = date.minusDays(dayOfMonth - 1).minus(1).toDateTime();
                dayOfMonth = lastMonth.dayOfMonth().get();

                date = lastMonth.minusDays(dayOfMonth).toDateTime();

                startDateParam = date.plus(1).toDate();
                endDatePram = lastMonth.toDate();
            } else if (dateRange == 5) {//this year
                DateTime enddate = new DateTime().toDateTime();
                int dayOfYear = enddate.dayOfYear().get();
                DateTime lastMonth = enddate.minusDays(dayOfYear - 1).toDateMidnight().toDateTime();

                startDateParam = lastMonth.toDate();
                endDatePram = enddate.toDate();
            } else if (dateRange == 6) {//last year
                DateTime endDate = new DateTime().toDateTime();

                endDate = endDate.minusDays(endDate.getDayOfYear()).toDateMidnight().minus(1).toDateTime();
                DateTime startDate = endDate.minusMonths(12).plus(1);

                startDateParam = startDate.toDate();
                endDatePram = endDate.toDate();
            } else if (dateRange == 7) {//All
                DateTime enddate = new DateTime().toDateTime();

                startDateParam = enddate.toDate();
                endDatePram = enddate.toDate();
            }

        } else {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");       //06/01/2012
            startDateParam = DateTime.parse(startDate, fmt).toDate();
            endDatePram = DateTime.parse(endDate, fmt).plusDays(1).minus(1).toDate(); //EOD


        }
        OrderFilter orderFilter = new OrderFilter(0, 10);

        try {
            if (getCustomerId() > 0) {
                CustomerEntity customerEntity = userManagement.getCustomer(getCustomerId());
                orderFilter.setCustomer(customerEntity);

            }


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        orderFilter.setStartDate(startDateParam);
        orderFilter.setEndDate(endDatePram);
        if (getCity() != null && !getCity().trim().isEmpty())
            orderFilter.setCity(getCity());
        orderEntities = orderManagement.getOrders(orderFilter);


        return SUCCESS;
    }

    public String doListPayments() {
        Date startDateParam = null, endDatePram = null;


        if (dateFilterType == 0) {
            if (dateRange == 0) {//today
                DateTime date = new DateTime().toDateMidnight().toDateTime();
                DateTime tomorrow = date.plusDays(1);

                startDateParam = date.toDate();
                endDatePram = tomorrow.toDate();
            } else if (dateRange == 1) {//yesterday
                DateTime date = new DateTime().toDateMidnight().toDateTime().minus(1);
                DateTime yesterday = date.minusDays(1).plus(1);

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 2) {//last 7 days
                DateTime date = new DateTime();
                DateTime yesterday = date.minusDays(7).toDateMidnight().toDateTime();

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 3) {//this month
                DateTime date = new DateTime();
                int dayOfMonth = date.dayOfMonth().get();
                DateTime yesterday = date.minusDays(dayOfMonth - 1).toDateMidnight().toDateTime();

                startDateParam = yesterday.toDate();
                endDatePram = date.toDate();
            } else if (dateRange == 4) {//last month
                DateTime date = new DateTime().toDateMidnight().toDateTime();
                int dayOfMonth = date.dayOfMonth().get();
                DateTime lastMonth = date.minusDays(dayOfMonth - 1).minus(1).toDateTime();
                dayOfMonth = lastMonth.dayOfMonth().get();

                date = lastMonth.minusDays(dayOfMonth).toDateTime();

                startDateParam = date.plus(1).toDate();
                endDatePram = lastMonth.toDate();
            } else if (dateRange == 5) {//this year
                DateTime enddate = new DateTime().toDateTime();
                int dayOfYear = enddate.dayOfYear().get();
                DateTime lastMonth = enddate.minusDays(dayOfYear - 1).toDateMidnight().toDateTime();

                startDateParam = lastMonth.toDate();
                endDatePram = enddate.toDate();
            } else if (dateRange == 6) {//last year
                DateTime endDate = new DateTime().toDateTime();

                endDate = endDate.minusDays(endDate.getDayOfYear()).toDateMidnight().minus(1).toDateTime();
                DateTime startDate = endDate.minusMonths(12).plus(1);

                startDateParam = startDate.toDate();
                endDatePram = endDate.toDate();
            } else if (dateRange == 7) {//All
                DateTime enddate = new DateTime().toDateTime();

                startDateParam = enddate.toDate();
                endDatePram = enddate.toDate();
            }

        } else {
            DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");       //06/01/2012
            startDateParam = DateTime.parse(startDate, fmt).toDate();
            endDatePram = DateTime.parse(endDate, fmt).plusDays(1).minus(1).toDate(); //EOD


        }
        PaymentFilter paymentFilter = new PaymentFilter(0, 10);


        if (paymentAmount != null && paymentAmount.intValue() > 0)
            paymentFilter.setAmount(paymentAmount);
        try {
            if (getCustomerId() > 0) {
                CustomerEntity customerEntity = userManagement.getCustomer(getCustomerId());
                paymentFilter.setCustomer(customerEntity);

            }


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        paymentFilter.setStartDate(startDateParam);
        paymentFilter.setEndDate(endDatePram);
        if (getCity() != null && !getCity().trim().isEmpty())
            paymentFilter.setCity(getCity());
        if (getCredited() > 0)
            paymentFilter.setCredited(true);
        if (getPaymentType() > 0)
            paymentFilter.setType(PaymentType.CASH.getType(getPaymentType()));


        this.paymentEntities = paymentManager.searchPayments(paymentFilter);

        return SUCCESS;
    }


    public String doLedger() {
        OrderFilter orderFilter = new OrderFilter(0, 10);

        try {
            this.customer = userManagement.getCustomer(customerId);
            orderFilter.setCustomer(customer);

            this.paymentEntities = paymentManager.getPaymentsByUser(customer);
            orderEntities = orderManagement.getOrders(orderFilter);


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }

        return SUCCESS;
    }

    public BigDecimal getTotalDueAmount() {

        BigDecimal total = new BigDecimal(0);

        if (orderEntities != null) {
            for (OrderEntity item : orderEntities) {

                total = total.add(item.getDueAmount());

            }
        }
        return total;
    }

    public BigDecimal getTotalOrderAmount() {

        BigDecimal total = new BigDecimal(0);

        if (orderEntities != null) {
            for (OrderEntity item : orderEntities) {

                total = total.add(item.getTotalAmount());

            }
        }

        return total;
    }

    public BigDecimal getTotalPaymentAmount() {

        BigDecimal total = new BigDecimal(0);


        if (paymentEntities != null) {
            for (PaymentEntity item : paymentEntities) {

                total = total.add(item.getAmount());

            }
        }

        return total;
    }

    public BigDecimal getOrdersTotalPaymentAmount() {

        BigDecimal total = new BigDecimal(0);


        if (orderEntities != null) {
            for (OrderEntity item : orderEntities) {

                total = total.add(item.getPaymentAmount());

            }
        }

        return total;
    }


    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }


    private int dateFilterType;

    private String city;
    private String startDate;

    private String endDate;

    private int dateRange = 0;

    private BigDecimal paymentAmount;

    private int credited = -1;

    private int paymentType = -1;

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getDateFilterType() {
        return dateFilterType;
    }

    public void setDateFilterType(int dateFilterType) {
        this.dateFilterType = dateFilterType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDateRange() {
        return dateRange;
    }

    public void setDateRange(int dateRange) {
        this.dateRange = dateRange;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCredited() {
        return credited;
    }

    public void setCredited(int credited) {
        this.credited = credited;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }
}
