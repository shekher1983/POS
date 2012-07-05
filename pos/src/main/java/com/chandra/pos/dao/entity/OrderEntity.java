package com.chandra.pos.dao.entity;

import com.chandra.pos.model.OrderStatus;
import com.chandra.pos.model.OrderType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/14/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    public static int AMOUNT_PRECISION = 2;

    private long id;

    private CustomerEntity customer;


    private EmployeeEntity employee;


    private OrderType orderType;


    /*
   shipping amount to be calculated in total amount
    */
    private BigDecimal shippingAmount;

    private BigDecimal totalAmount;

    private BigDecimal dueAmount;
    /*
     Tax amount to be calculated in total amount
    */
    private BigDecimal taxAmount;
    /*
      Miscellaneous charges
     */
    private BigDecimal otherCharge;

    private BigDecimal discount;

    private long orderDate;

    private long shippingDate;

    //private long orderStatus;

    private OrderStatus orderStatus;

    private String note;


    private Set<OrderItemEntity> itemList = new HashSet<OrderItemEntity>(0);

    private Set<OrderPaymentEntity> paymentList = new HashSet<OrderPaymentEntity>(0);


    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID", unique = false, nullable = true, updatable = true, insertable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @OneToOne
    @JoinColumn(name = "EMPLOYEE_ID", unique = false, nullable = true, updatable = true, insertable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Column(name = "SHIPPING_AMOUNT")
    public BigDecimal getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(BigDecimal shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    @Column(name = "TAX_AMOUNT")
    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Column(name = "OTHER_AMOUNT")
    public BigDecimal getOtherCharge() {
        return otherCharge;
    }

    public void setOtherCharge(BigDecimal otherCharge) {
        this.otherCharge = otherCharge;
    }

    @Column(name = "DISCOUNT")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Column(name = "ORDER_DATE")
    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    @Column(name = "SHIPPING_DATE")
    public long getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(long shippingDate) {
        this.shippingDate = shippingDate;
    }


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ORDER_STATUS_ID")
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.order", cascade=CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.order", cascade = CascadeType.ALL)
    public Set<OrderItemEntity> getItemList() {
        return itemList;
    }

    public void setItemList(Set<OrderItemEntity> itemList) {
        this.itemList = itemList;
    }


    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /*
     save due amount for reporting purpose
     what if customer pay later this field should be updated according to that
     may be just update the order status to PAID & COMPLETED
    */


    public void setDueAmount(BigDecimal dueAmount) {
        this.dueAmount = dueAmount;
    }

    //@OneToMany(cascade = CascadeType.ALL)
    // @JoinTable(name = "ORDER_PAYMENTS", joinColumns = {@JoinColumn(name = "ORDER_ID")}, inverseJoinColumns = {@JoinColumn(name = "PAYMENT_ID")})
    //@LazyCollection(LazyCollectionOption.FALSE)

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID", updatable = true, insertable = true)
    public Set<OrderPaymentEntity> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Set<OrderPaymentEntity> paymentList) {
        this.paymentList = paymentList;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ORDER_TYPE_ID")
    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    @Column(name = "DUE_AMOUNT")
    public BigDecimal getDueAmount() {

        BigDecimal total = this.getTotalAmount();


        total = total.subtract(getPaymentAmount());


        return total;

    }

    @Transient
    public BigDecimal getPaymentAmount() {

        BigDecimal total = new BigDecimal(0);

        if (paymentList != null) {
            for (OrderPaymentEntity item : paymentList) {

                total = total.add(item.getAmount());

            }
        }

        return total;

    }

    @Transient
    public BigDecimal getSubTotalAmount() {


        BigDecimal subTotal = new BigDecimal(0);

        if (itemList != null)
            for (OrderItemEntity item : itemList) {

                subTotal = subTotal.add(item.getTotalAmount());

            }

        subTotal = subTotal.setScale(AMOUNT_PRECISION, RoundingMode.HALF_UP);

        return subTotal;
    }

    @Column(name = "TOTAL_AMOUNT")
    public BigDecimal getTotalAmount() {

        BigDecimal total = getSubTotalAmount();


        if (discount != null)
            total = total.subtract(discount);

        if (otherCharge != null)
            total = total.add(otherCharge);

        if (taxAmount != null)
            total = total.add(taxAmount);

        if (shippingAmount != null)
            total = total.add(shippingAmount);

        total = total.setScale(AMOUNT_PRECISION, RoundingMode.HALF_UP);
        totalAmount = total;
        return total;
    }


}
