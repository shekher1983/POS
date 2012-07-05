package com.chandra.pos.service.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.*;
import com.chandra.pos.dao.entity.*;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.service.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Service("orderManagement")
@Transactional(readOnly = false)
public class OrderManagementImpl implements OrderManagement {


    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired
    private StoreConfig config;
    private OrderDAO orderDAO;
    private ProductDAO productDAO;
    private UserDAO userDAO;

    private StatusDAO statusDAO;


    public StatusDAO getStatusDAO() {
        return statusDAO;
    }

    @Autowired
    public void setStatusDAO(StatusDAO statusDAO) {
        this.statusDAO = statusDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public void setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @Override
    @Transactional(readOnly = false)

    public OrderEntity createOrder(OrderEntity orderEntityEntity) {


        orderEntityEntity.setOrderDate(new Date().getTime());
        orderEntityEntity.setShippingDate(new Date().getTime());

        if (orderEntityEntity.getCustomer() == null)
            orderEntityEntity.setCustomer(new CustomerEntity(-1));


        Set<OrderItemEntity> orderItemList = orderEntityEntity.getItemList();

        for (OrderItemEntity itemEntity : orderEntityEntity.getItemList()) {
            itemEntity.setOrder(orderEntityEntity);
        }
        orderEntityEntity.setItemList(orderItemList);


        orderDAO.saveOrder(orderEntityEntity);

        orderEntityEntity.setId(orderEntityEntity.getId());


        return orderEntityEntity;
    }

    @Override
    public List<OrderEntity> getOrders(OrderFilter filter) {
//        List<OrderEntity> orderEntityEntityList;
//        if (filter.getCustomer() != null)
//            orderEntityEntityList = orderDAO.listOrdersByUser(filter.getCustomer());
//
//        else if (filter.getStatus() != null)
//            orderEntityEntityList = orderDAO.listOrdersByStatus(filter.getStatus());
//
//        else

        //  orderEntityEntityList = ;

        return orderDAO.listOrdersUsingFilter(filter);
    }


    @Override
    public OrderEntity getOrder(long id) throws EntityNotFoundException {

        OrderEntity orderEntityEntity = null;  //To change body of implemented methods use File | Settings | File Templates.

        orderEntityEntity = orderDAO.getOrderById(id);

        return orderEntityEntity;
    }


    @Override
    public OrderEntity updateOrder(OrderEntity orderEntityEntity) {
        orderEntityEntity.setOrderDate(new Date().getTime());
        orderEntityEntity.setShippingDate(new Date().getTime());

        if (orderEntityEntity.getCustomer() == null)
            orderEntityEntity.setCustomer(new CustomerEntity(-1));


        Set<OrderItemEntity> orderItemList = orderEntityEntity.getItemList();

        for (OrderItemEntity itemEntity : orderEntityEntity.getItemList()) {
            itemEntity.setOrder(orderEntityEntity);
        }
        orderEntityEntity.setItemList(orderItemList);

        Set<OrderPaymentEntity> paymentList = orderEntityEntity.getPaymentList();

        orderEntityEntity.setPaymentList(paymentList);

        orderDAO.editOrder(orderEntityEntity);

        orderEntityEntity.setId(orderEntityEntity.getId());


        return orderEntityEntity;
    }

    @Override
    public boolean deleteOrder(OrderEntity orderEntity) {
        orderDAO.removeOrder(orderEntity);

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public StoreConfig getStoreConfig() {
        return config;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public StoreConfig getConfig() {
        return config;
    }

    public void setConfig(StoreConfig config) {
        this.config = config;
    }
}
