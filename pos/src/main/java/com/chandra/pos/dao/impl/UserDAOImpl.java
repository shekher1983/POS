package com.chandra.pos.dao.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.UserDAO;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;
import com.chandra.pos.model.UserFilter;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/15/12
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository

public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    public void setupSessionFactory(SessionFactory sessionFactory) {
//        this.setSessionFactory(sessionFactory);
//    }


    @Override
    public EmployeeEntity getEmployee(long employeeid) throws EntityNotFoundException {
        // UserEntity entity = this.getHibernateTemplate().load(UserEntity.class, userid);
        EmployeeEntity entity = (EmployeeEntity) sessionFactory.getCurrentSession().get(EmployeeEntity.class, employeeid);

        if (entity == null)
            throw new EntityNotFoundException("user Not Found");
        return entity;
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        // this.getHibernateTemplate().save(userEntity);
        Long id = (Long) sessionFactory.getCurrentSession().save(employeeEntity);


        return employeeEntity;
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        sessionFactory.getCurrentSession().update(employeeEntity);
        return employeeEntity;
    }

    @Override
    public List<EmployeeEntity> listEmployee(String userName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public List<EmployeeEntity> getEmployees(int start, int resultSize) {
        Query query = sessionFactory.getCurrentSession().createQuery("from EmployeeEntity");
        query.setFirstResult(start);
        query.setMaxResults(resultSize);
        //List obj = .createQuery(UserEntity.class);
        return query.list();
    }

    @Override
    public EmployeeEntity getEmployeeByUserName(String userName) throws EntityNotFoundException {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeEntity.class);

        criteria.add(Restrictions.ge("userName", userName));

        EmployeeEntity entity = (EmployeeEntity) criteria.uniqueResult();

        if (entity == null)
            throw new EntityNotFoundException("user Not Found");
        return entity;//To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<CustomerEntity> listCustomers(UserFilter filter) {
        Query query = sessionFactory.getCurrentSession().createQuery("from CustomerEntity");
        query.setFirstResult(filter.getStart());
        query.setMaxResults(filter.getPageSize());
        //List obj = .createQuery(UserEntity.class);
        return query.list();
    }

    @Override
    public CustomerEntity getCustomer(long employeeid) throws EntityNotFoundException {
        CustomerEntity entity = (CustomerEntity) sessionFactory.getCurrentSession().get(CustomerEntity.class, employeeid);

        if (entity == null)
            throw new EntityNotFoundException("user Not Found");
        return entity;
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity employeeEntity) {
        sessionFactory.getCurrentSession().save(employeeEntity);
        return employeeEntity;
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity employeeEntity) {
        sessionFactory.getCurrentSession().update(employeeEntity);
        return employeeEntity;
    }

    @Override
    public List<CustomerEntity> listCustomer(String userName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CustomerEntity getCustomerByUserName(String s) throws EntityNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<CustomerEntity> searchCustomerByName(UserFilter filter) {
        Query query = sessionFactory.getCurrentSession().createQuery("from CustomerEntity u where  u.lastName like :lastname OR u.firstName like :firstname  ");
        query.setParameter("lastname", "%" + filter.getNameQuery() + "%");
        query.setParameter("firstname", "%" + filter.getNameQuery() + "%");

        List<CustomerEntity> result = query.list();

        return result;
    }

    @Override
    public List<CustomerEntity> searchCustomer(UserFilter filter) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CustomerEntity.class);
        criteria.add(Restrictions.eq("supplier", filter.isSupplier()));
        if (filter.getNameQuery() != null) {
            String temp = "%" + filter.getNameQuery() + "%";
            Criterion cr1 = Restrictions.like("firstName", temp);
            Criterion cr2 = Restrictions.like("lastName", temp);
            Criterion cr3 = Restrictions.like("nickName", temp);
            Criterion cr4 = Restrictions.like("primaryCell", temp);
            criteria.add(Restrictions.or(cr1, cr2, cr3,cr4));

        }
        if (filter.getCity() != null && !filter.getCity().isEmpty())

            criteria.add(Restrictions.eq("city", filter.getCity()));


        return criteria.list();  //To change body of implemented methods use File | Settings | File Templates.
    }

}
