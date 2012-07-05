package com.chandra.pos.dao.impl;

import com.chandra.pos.dao.StatusDAO;
import com.chandra.pos.dao.entity.StatusEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/18/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository

public class StatusDAOImpl extends HibernateDaoSupport implements StatusDAO {


    @Autowired
    public void setupSessionFactory(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }


    @Override
    public StatusEntity getStatus(long id) {
        StatusEntity order = this.getHibernateTemplate().load(StatusEntity.class, id);

        return order;
    }

    @Override
    public List<StatusEntity> getAllStatus() {


        return this.getHibernateTemplate().find("form StatusEntity ");
    }
}
