package com.chandra.pos.service.impl;

import com.chandra.pos.dao.PaymentDAO;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.PaymentFilter;
import com.chandra.pos.service.PaymentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/10/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("paymentManager")
@Transactional(readOnly = false)
public class PaymentManagerImpl implements PaymentManager {

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public PaymentEntity savePayment(PaymentEntity paymentEntity) {
        return paymentDAO.savePayment(paymentEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity paymentEntity) {
        paymentEntity.setLastModified(new Date().getTime());
        return paymentDAO.updatePayment(paymentEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean deletePayment(PaymentEntity paymentEntity) {
        return paymentDAO.deletePayment(paymentEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PaymentEntity getPayment(long id) {
        return paymentDAO.getPayment(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PaymentEntity> getPaymentsByUser(CustomerEntity userId) {
        return paymentDAO.getPaymentsByUser(userId);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PaymentEntity> getPaymentsByDate(long startDate, long endDate) {
        return paymentDAO.getPaymentsByDate(startDate, endDate);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BigDecimal getTotalPaymentByUser(CustomerEntity userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BigDecimal getTotalPaymentByDate(long startDate, long endDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List<PaymentEntity> searchPayments(PaymentFilter paymentFilter) {
        return paymentDAO.searchPayments(paymentFilter);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
