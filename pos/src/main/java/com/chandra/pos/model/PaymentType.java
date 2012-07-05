package com.chandra.pos.model;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/29/12
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 * http://www.coderanch.com/t/484121/Struts/enum-select-Struts
 */
public enum PaymentType {
    CASH(0, "Cash"),
    CHECK(1, "Check"),
    BANK_TRANSFER(2, "Bank Transfer");

    private final int id;   // in kilograms

    private final String name;

    PaymentType(int id, String status) {
        this.id = id;
        this.name = status;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static PaymentType getType(int id) {

        PaymentType[] types = PaymentType.values();

        for (PaymentType type : types) {
            if (type.getId() == id)
                return type;
        }
        return null;
    }

}
