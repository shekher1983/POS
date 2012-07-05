package com.chandra.pos.dao.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.CategoryDAO;
import com.chandra.pos.dao.entity.CategoryEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/29/12
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository

public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public CategoryEntity getCategory(long categoryid) throws EntityNotFoundException {
        // UserEntity entity = this.getHibernateTemplate().load(UserEntity.class, userid);
        CategoryEntity entity = (CategoryEntity) sessionFactory.getCurrentSession().get(CategoryEntity.class, categoryid);

        if (entity == null)
            throw new EntityNotFoundException();
        return entity;
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        // this.getHibernateTemplate().save(userEntity);
        Long id = (Long) sessionFactory.getCurrentSession().save(categoryEntity);

        categoryEntity.setId(id);
        return categoryEntity;
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        sessionFactory.getCurrentSession().update(categoryEntity);
        return categoryEntity;
    }

    @Override
    public List<CategoryEntity> searchCategory(String name) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<CategoryEntity> listCategory(int start, int pageSize) {
        Query query = sessionFactory.getCurrentSession().createQuery("from CategoryEntity");
        query.setFirstResult(start);
        query.setMaxResults(pageSize);
        //List obj = .createQuery(UserEntity.class);
        return query.list();
    }
}
