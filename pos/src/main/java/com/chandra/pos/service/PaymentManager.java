package com.chandra.pos.service;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.PaymentFilter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/10/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */


public interface PaymentManager {

    public PaymentEntity savePayment(PaymentEntity paymentEntity);

    public PaymentEntity updatePayment(PaymentEntity paymentEntity);

    public boolean deletePayment(PaymentEntity paymentEntity) throws EntityNotFoundException;

    public PaymentEntity getPayment(long id) throws EntityNotFoundException;

    public List<PaymentEntity> getPaymentsByUser(CustomerEntity userId);

    public List<PaymentEntity> getPaymentsByDate(long startDate, long endDate);

    public BigDecimal getTotalPaymentByUser(CustomerEntity userId);

    public BigDecimal getTotalPaymentByDate(long startDate, long endDate);

    List<PaymentEntity> searchPayments(PaymentFilter paymentFilter);
}
