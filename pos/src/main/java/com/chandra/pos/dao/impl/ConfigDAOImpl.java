package com.chandra.pos.dao.impl;

import com.chandra.pos.dao.ConfigDAO;
import com.chandra.pos.dao.entity.PropertyEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/8/12
 * Time: 5:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository

public class ConfigDAOImpl implements ConfigDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public PropertyEntity getPropertyEntity(String key) {
        // return  sessionFactory.getCurrentSession().get(PropertyEntity.class,key) ;  //To change body of implemented methods use File | Settings | File Templates.
        return null;
    }

    @Override
    public PropertyEntity saveProperty(PropertyEntity propertyEntity) {
        sessionFactory.getCurrentSession().save(propertyEntity);
        return propertyEntity;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PropertyEntity updateProperty(PropertyEntity propertyEntity) {
        sessionFactory.getCurrentSession().save(propertyEntity);
        return propertyEntity;
    }

    @Override
    public boolean deleteProperty(PropertyEntity propertyEntity) {
        sessionFactory.getCurrentSession().delete(propertyEntity);
        return true;
    }
}
