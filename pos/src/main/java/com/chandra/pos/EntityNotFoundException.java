package com.chandra.pos;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: root
 * Date: 6/7/12
 * Time: 8:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityNotFoundException extends Exception {

    String error;

    public EntityNotFoundException() {
        super();             // call superclass constructor

    }

    public EntityNotFoundException(String err) {
        super(err);     // call super class constructor
        this.error = err;  // save message
    }

    public String getError() {
        return error;
    }

}
