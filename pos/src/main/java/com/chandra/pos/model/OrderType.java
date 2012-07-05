package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/20/12
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */

public enum OrderType {

    SALE(0, "Sale"),
    PURCHASE(1, "Purchase");

    private final int id;   // in kilograms

    private final String name;

    OrderType(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OrderType getType(int id) {

        OrderType[] types = OrderType.values();

        for (OrderType type : types) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }
}
