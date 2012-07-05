package com.chandra.pos.dao.impl;

import com.chandra.pos.dao.PaymentDAO;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.PaymentEntity;
import com.chandra.pos.model.PaymentFilter;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/2/12
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PaymentDAOImpl implements PaymentDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PaymentEntity savePayment(PaymentEntity paymentEntity) {
        Long id = (Long) sessionFactory.getCurrentSession().save(paymentEntity);

        paymentEntity.setId(id);
        return paymentEntity;
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity paymentEntity) {
        sessionFactory.getCurrentSession().update(paymentEntity);
        return paymentEntity;
    }

    @Override
    public boolean deletePayment(PaymentEntity paymentEntity) {


        sessionFactory.getCurrentSession().delete(paymentEntity);
        return true;
    }

    @Override
    public PaymentEntity getPayment(long id) {
        // UserEntity entity = this.getHibernateTemplate().load(UserEntity.class, userid);
        PaymentEntity entity = (PaymentEntity) sessionFactory.getCurrentSession().get(PaymentEntity.class, id);
        return entity;
    }

    @Override
    public List<PaymentEntity> getPaymentsByUser(CustomerEntity userId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PaymentEntity u where u.customer =:userId");
        List<PaymentEntity> result = query.setParameter("userId", userId).list();

        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PaymentEntity> getPaymentsByDate(long startDate, long endDate) {

        Query query = sessionFactory.getCurrentSession().createQuery("from PaymentEntity u where u.paymentDate > :startDate and u.paymentDate < :endDate");

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<PaymentEntity> result = query.list();

        return result;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public BigDecimal getTotalPaymentByUser(long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BigDecimal getTotalPaymentByDate(long startDate, long endDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List<PaymentEntity> searchPayments(PaymentFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PaymentEntity.class);

        if (filter.getStartDate() != null && filter.getEndDate() != null)
            criteria.add(Restrictions.ge("paymentDate", filter.getStartDate().getTime()));
        if (filter.getEndDate() != null)
            criteria.add(Restrictions.le("paymentDate", filter.getEndDate().getTime()));

        if (filter.getCustomer() != null)
            criteria.add(Restrictions.eq("customer", filter.getCustomer()));

        if (filter.getAmount() != null)
            criteria.add(Restrictions.eq("amount", filter.getAmount()));
        if (filter.getType() != null)
            criteria.add(Restrictions.eq("type", filter.getType()));
//              if (filter.isCredited() != null)
//                     criteria.add(Restrictions.eq("type", filter.getType()));


        if (filter.getCity() != null)
            criteria.createCriteria("customer").add(Restrictions.eq("city", filter.getCity()));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        return criteria.list();  //To change body of implemented methods use File | Settings | File Templates.
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
