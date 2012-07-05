package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/30/12
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
public enum OrderStatus {

    DELETED(0, "Cash"),
    COMPLETED(1, "Check"),
    SUSPENDED(2, "Bank Transfer"),
    PAID(0, "Cash"),
    SHIPPED(1, "Check"),
    CANCELLED(0, "Cash"),
    RETURNED(1, "Check"),
    RECEIVED(1, "Check");

    private final int id;   // in kilograms

    private final String name;

    OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OrderStatus getType(int id) {

        OrderStatus[] types = OrderStatus.values();

        for (OrderStatus type : types) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }
}
