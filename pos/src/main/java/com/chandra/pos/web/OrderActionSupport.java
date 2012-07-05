package com.chandra.pos.web;

import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.model.PaymentType;
import com.chandra.pos.service.OrderManagement;
import com.chandra.pos.service.PaymentManager;
import com.chandra.pos.service.ProductService;
import com.chandra.pos.service.UserManagement;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 7/1/12
 * Time: 1:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderActionSupport extends ActionSupport implements SessionAware {

    private UserManagement userManagement;

    private ProductService productService;

    private OrderManagement orderManagement;

    private Map session;
    private PaymentManager paymentManager;

    public List<OrderEntity> getOrderEntityList() {
        return orderEntityList;
    }

    public void setOrderEntityList(List<OrderEntity> orderEntityList) {
        this.orderEntityList = orderEntityList;
    }

    private List<OrderEntity> orderEntityList;


    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public PaymentManager getPaymentManager() {
        return paymentManager;
    }

    public void setPaymentManager(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }

    protected List<OrderEntity> loadOrders(OrderFilter filter) {
        orderEntityList = getOrderManagement().getOrders(filter);

        return orderEntityList;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public PaymentType[] getPaymentTypes() {
        return PaymentType.values();

    }

    public Map getSession() {
        return session;
    }

    protected String errorMsg;
    private int dateFilterType = 0;

    private String city;
    private String startDate;

    private String endDate;

    private int dateRange = 0;

    private BigDecimal paymentAmount;

    private int credited = -1;

    private int paymentType = -1;


    private int mode = 1;
    private String comment;

    private long orderId;

    private long customerId;

    private long itemId;

    private BigDecimal price;

    private BigDecimal discount;

    private BigDecimal quantity;
    private BigDecimal shippingAmount;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }


    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }


    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

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
