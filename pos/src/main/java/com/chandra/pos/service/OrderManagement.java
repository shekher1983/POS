package com.chandra.pos.service;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.OrderEntity;
import com.chandra.pos.dao.entity.StoreConfig;
import com.chandra.pos.model.OrderFilter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderManagement {


    /*
       Create a new orderEntity
     */
    public OrderEntity createOrder(OrderEntity orderEntity);


    /*
      List purchase order based on filter
    */
    public List<OrderEntity> getOrders(OrderFilter filter);


    public OrderEntity getOrder(long id) throws EntityNotFoundException;


    public OrderEntity updateOrder(OrderEntity orderEntity);

    public boolean deleteOrder(OrderEntity orderEntity);

    public StoreConfig getStoreConfig();
}
