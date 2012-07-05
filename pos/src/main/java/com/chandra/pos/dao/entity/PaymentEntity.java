package com.chandra.pos.dao.entity;

import com.chandra.pos.model.PaymentType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/2/12
 * Time: 1:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PAYMENTS")
public class PaymentEntity {


    private Long id;


    private Long paymentDate;

    private String note;

    private BigDecimal amount;

    private EmployeeEntity employee;

    private CustomerEntity customer;

    private PaymentType type;
    private Boolean credited;

    private Long lastModified;

    @Column(name = "PAYMENT_ID")
    @Id
    @GeneratedValue
    public Long getId() {
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


    public void setCredited(Boolean credited) {
        this.credited = credited;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Column(name = "PAYMENT_DATE")
    public Long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Long paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Column(name = "IS_CREDITED", nullable = false, columnDefinition = "tinyint default false")

    public Boolean getCredited() {
        return credited;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    //    @OneToOne
//    @JoinColumn(name = "PAYMENT_TYPE_ID")
    @Column(name = "PAYMENT_TYPE_ID")
    @Enumerated(EnumType.ORDINAL)
    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }


    @Column(name = "PAYMENT_AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    @Column(name = "LAST_MODIFIED")
    public Long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }
}
