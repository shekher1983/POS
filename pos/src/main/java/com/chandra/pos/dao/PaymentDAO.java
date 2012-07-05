package com.chandra.pos.dao;

import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.PaymentFilter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/2/12
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PaymentDAO {


    public PaymentEntity savePayment(PaymentEntity paymentEntity);

    public PaymentEntity updatePayment(PaymentEntity paymentEntity);

    public boolean deletePayment(PaymentEntity paymentEntity);

    public PaymentEntity getPayment(long id);

    public List<PaymentEntity> getPaymentsByUser(CustomerEntity userId);

    public List<PaymentEntity> getPaymentsByDate(long startDate, long endDate);

    public BigDecimal getTotalPaymentByUser(long userId);

    public BigDecimal getTotalPaymentByDate(long startDate, long endDate);

    public List<PaymentEntity> searchPayments(PaymentFilter paymentFilter);
}
