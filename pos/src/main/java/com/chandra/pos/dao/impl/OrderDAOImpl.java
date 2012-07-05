package com.chandra.pos.dao.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.OrderDAO;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.dao.entity.OrderItemEntity;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.model.OrderStatus;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 2:21 PM
 * DAO for managing order
 */
@Repository

public class OrderDAOImpl implements OrderDAO {


    public List<OrderEntity> listOrdersUsingFilter(OrderFilter filter) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OrderEntity.class);

        if (filter.getStartDate() != null && filter.getEndDate() != null)
            criteria.add(Restrictions.ge("orderDate", filter.getStartDate().getTime()));
        if (filter.getEndDate() != null)
            criteria.add(Restrictions.le("orderDate", filter.getEndDate().getTime()));

        if (filter.getCustomer() != null)
            criteria.add(Restrictions.eq("customer", filter.getCustomer()));

        if (filter.getStatus() != null)
            criteria.add(Restrictions.eq("orderStatus", filter.getStatus()));

        if (filter.getOrderType() != null)
            criteria.add(Restrictions.eq("orderType", filter.getOrderType()));

        if (filter.getCity() != null)
            criteria.createCriteria("customer").add(Restrictions.eq("city", filter.getCity()));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);


        return criteria.list();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<OrderEntity> listOrdersByDate(long startDate, long endDate) {
        Query query = sessionFactory.getCurrentSession().createQuery("from OrderEntity u where u.orderDate > :startDate and u.orderDate < :endDate");

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<OrderEntity> result = query.list();

        return result;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        // this.getHibernateTemplate().save(userEntity);
        sessionFactory.getCurrentSession().save(order);


        return order;
    }

    @Override
    public boolean removeOrder(OrderEntity order) {

        sessionFactory.getCurrentSession().delete(order);

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OrderEntity editOrder(OrderEntity order) {
        sessionFactory.getCurrentSession().update(order);
        return order;
    }

    @Override
    public List<OrderEntity> getOrders(long customerId, java.util.Date startDate, java.util.Date endDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OrderEntity getOrderById(long orderId) throws EntityNotFoundException {


        // UserEntity entity = this.getHibernateTemplate().load(UserEntity.class, userid);
        OrderEntity entity = (OrderEntity) sessionFactory.getCurrentSession().get(OrderEntity.class, orderId);
        if (entity == null)
            throw new EntityNotFoundException("OrderEntity Not Found");

        return entity;


    }

    @Override
    public List<OrderItemEntity> getProductsByOrderId(long orderId) {


//        List<OrderItemEntity> items = this.sessionFactory.getCurrentSession().(
//                "from  OrderItemEntity "
//                        + "where ORDER_ID = :ORDER_ID", "ORDER_ID", orderId);

        return null;
    }

    @Override
    public List<OrderEntity> listOrdersByStatus(OrderStatus id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from OrderEntity u where u.orderStatus =:status");
        query.setParameter("status", id);

        try {
            List<OrderEntity> result = query.list();
            return result;

        } catch (ObjectNotFoundException e) {
            //      logger.error("Mapping id might be missing in the referenced table");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<OrderEntity> listOrdersByUser(CustomerEntity uid) {
        Query query = sessionFactory.getCurrentSession().createQuery("from OrderEntity u where u.customer =:customer");
        query.setParameter("customer", uid);


        try {
            List<OrderEntity> result = query.list();
            return result;

        } catch (ObjectNotFoundException e) {
            //      logger.error("Mapping id might be missing in the referenced table");
            e.printStackTrace();
            return null;
        }

    }
}
