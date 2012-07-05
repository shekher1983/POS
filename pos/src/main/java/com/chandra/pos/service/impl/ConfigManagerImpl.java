package com.chandra.pos.service.impl;

import com.chandra.pos.dao.ConfigDAO;
import com.chandra.pos.dao.entity.PropertyEntity;
import com.chandra.pos.dao.entity.StoreConfig;
import com.chandra.pos.service.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("configManagerl")
public class ConfigManagerImpl implements ConfigManager {


    @Autowired
    private ConfigDAO configDAO;


    @Override
    public StoreConfig getStoreConfig() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public StoreConfig updateStoreConfig() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyEntity saveProperty(PropertyEntity property) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyEntity getProperty(PropertyEntity property) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyEntity removeProperty(PropertyEntity property) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
