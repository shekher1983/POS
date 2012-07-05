package com.chandra.pos.dao;

import com.chandra.pos.dao.entity.PropertyEntity;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ConfigDAO {


    public PropertyEntity getPropertyEntity(String key);


    public PropertyEntity saveProperty(PropertyEntity propertyEntity);

    public PropertyEntity updateProperty(PropertyEntity propertyEntity);

    public boolean deleteProperty(PropertyEntity propertyEntity);

}
