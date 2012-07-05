package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 7/3/12
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Role {

    ROLE_ADMIN_ITEMS(0, "Items", "Add, Update, Delete, and Search items"),
    ROLE_ADMIN_SALES(1, "Sales ", "Process sales and returns"),
    ROLE_ADMIN_REPORTS(2, "Reports", "View and generate reports"),
    ROLE_ADMIN_CONFIG(3, "Store Config", "Change the store's configuration"),
    ROLE_ADMIN_CUSTOMERS(4, "Customers", "Add, Update, Delete, and Search customers"),
    ROLE_ADMIN_EMPLOYEES(5, "Employees", "Add, Update, Delete, and Search employees"),
    ROLE_ADMIN_SUPPLIER(6, "Suppliers", "Add, Update, Delete, and Search customers"),
    ROLE_ADMIN_PAYMENT(7, "Payments", "Add, Update, Delete, and Search Payments"),
    ROLE_ADMIN_PURCHASE(8, "Purchase", "Process purchase and returns");


    private final int id;
    private final String name;

    private final String description;

    Role(int id, String name, String description) {
        this.id = id;
        this.description = description;
        this.name = name;

    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static Role getType(int id) {

        Role[] types = Role.values();

        for (Role type : types) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }

}
