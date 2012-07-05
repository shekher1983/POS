package com.chandra.pos.service;

import com.chandra.pos.dao.entity.PropertyEntity;
import com.chandra.pos.dao.entity.StoreConfig;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ConfigManager {


    public StoreConfig getStoreConfig();

    public StoreConfig updateStoreConfig();


    public PropertyEntity saveProperty(PropertyEntity property);

    public PropertyEntity getProperty(PropertyEntity property);

    public PropertyEntity removeProperty(PropertyEntity property);

}
