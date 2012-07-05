package com.chandra.pos.web.payment.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.PaymentFilter;
import com.chandra.pos.model.PaymentType;
import com.chandra.pos.security.UserDetailsImpl;
import com.chandra.pos.service.PaymentManager;
import com.chandra.pos.service.UserManagement;
import com.chandra.pos.web.CRUDAction;
import com.opensymphony.xwork2.ActionSupport;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/4/12
 * Time: 11:26 PM
 * To change this template use File | Settings | File emplates.
 */
public class PaymentAction extends ActionSupport implements CRUDAction {


    private UserManagement userManagement;


    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    private List<PaymentEntity> paymentEntities;


    private PaymentEntity paymentEntity;

    @Autowired
    private PaymentManager paymentManager;

    private long customerId;

    private String comment;

    private String paymentDate;

    private long orderId;

    private long id;


    public boolean isCredited() {
        return credited;
    }

    public void setCredited(boolean credited) {
        this.credited = credited;
    }

    @Override
    public String doHome() {

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
        //if(getCredited() >0)
        //    paymentFilter.setCredited(true);
        if (getPaymentType() > 0)
            paymentFilter.setType(PaymentType.CASH.getType(getPaymentType()));


        this.paymentEntities = paymentManager.searchPayments(paymentFilter);

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doNew() {

        return INPUT;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doDelete() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doList() {

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
        //if(getCredited() >0)
        //     paymentFilter.setCredited(true);
        if (getPaymentType() > 0)
            paymentFilter.setType(PaymentType.CASH.getType(getPaymentType()));


        this.paymentEntities = paymentManager.searchPayments(paymentFilter);
        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doUpdate() {
        try {
            this.paymentEntity = paymentManager.getPayment(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }
        paymentEntity.setAmount(paymentAmount);
        paymentEntity.setNote(comment);

        paymentManager.updatePayment(paymentEntity);
        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doEdit() {
        try {
            this.paymentEntity = paymentManager.getPayment(id);
            this.id = paymentEntity.getId();
            this.comment = paymentEntity.getNote();
            this.paymentAmount = paymentEntity.getAmount();
            this.paymentDate = paymentEntity.getPaymentDate().toString();
            this.paymentType = paymentEntity.getType().getId();
            this.credited = paymentEntity.getCredited();

        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }

        return INPUT;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doSave() {
        CustomerEntity customer = null;
        try {
            customer = userManagement.getCustomer(customerId);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setCustomer(customer);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long uid = 0;
        if (principal instanceof UserDetailsImpl) {
            paymentEntity.setEmployee(((UserDetailsImpl) principal).getUser());

        }
        paymentEntity.setAmount(paymentAmount);
        paymentEntity.setNote(comment);
        paymentEntity.setPaymentDate(new Date().getTime());
        paymentEntity.setType(PaymentType.CASH.getType(paymentType));
        paymentEntity = paymentManager.savePayment(paymentEntity);
        this.paymentEntity = paymentEntity;
        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doSearch() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public String doReceipt() {
        try {
            this.paymentEntity = paymentManager.getPayment(id);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaymentType[] getPaymentTypes() {
        return PaymentType.values();

    }


    public List<PaymentEntity> getPaymentEntities() {
        return paymentEntities;
    }

    public void setPaymentEntities(List<PaymentEntity> paymentEntities) {
        this.paymentEntities = paymentEntities;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }


    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    private int dateFilterType;

    private String city;
    private String startDate;

    private String endDate;

    private int dateRange = 0;

    private BigDecimal paymentAmount;

    private Boolean credited;

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


}
