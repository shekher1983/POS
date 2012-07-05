package com.chandra.pos.dao;

import com.chandra.pos.dao.entity.OrderItemEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 6/6/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface OrderItemDAO {

    OrderItemEntity saveItem(OrderItemEntity entity);

    OrderItemEntity updateItem(OrderItemEntity entity);

    List<OrderItemEntity> getItemByOrder(long id);


}
