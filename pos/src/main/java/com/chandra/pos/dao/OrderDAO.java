package com.chandra.pos.dao;


import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.dao.entity.OrderItemEntity;
import com.chandra.pos.model.OrderFilter;
import com.chandra.pos.model.OrderStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDAO {

    public OrderEntity saveOrder(OrderEntity order);

    public boolean removeOrder(OrderEntity order);

    public OrderEntity editOrder(OrderEntity order);

    public List<OrderEntity> getOrders(long customerId, Date startDate, Date endDate);

    public OrderEntity getOrderById(long orderId) throws EntityNotFoundException;

    public List<OrderItemEntity> getProductsByOrderId(long orderId);


    List<OrderEntity> listOrdersByStatus(OrderStatus id);

    List<OrderEntity> listOrdersByUser(CustomerEntity uid);

    List<OrderEntity> listOrdersByDate(long time, long time1);

    List<OrderEntity> listOrdersUsingFilter(OrderFilter filter);
}
