package com.chandra.pos.service.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.UserDAO;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;

import com.chandra.pos.model.Filter;
import com.chandra.pos.model.UserFilter;
import com.chandra.pos.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/15/12
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("userManagement")
@Transactional(readOnly = false)
public class UserManagementImpl implements UserManagement {

    @Autowired
    private PasswordEncoder passwordEncoder = null;

    @Autowired
    private UserDAO userDAO;



    public void init() {


    }


//    @Override
//    public UserRoleEntity addUserRole(EmployeeEntity userEntity, RoleEntity userRole) {
//        UserRoleEntity userRoleEntity = new UserRoleEntity();
//        userRoleEntity.setCreated(new Date().getTime());
//        userRoleEntity.setRole(new RoleEntity(userRole.getId()));
//        //userRoleEntity.setUserId(userEntity.getId());
//        roleDAO.addUserRole(userRoleEntity);
//
//        return userRoleEntity;
//
//    }

//    @Override
//    public boolean removeUserRole(EmployeeEntity userEntity, RoleEntity userRole) {
//        UserRoleEntity userRoleEntity = new UserRoleEntity();
//        //userRoleEntity.setUserId(userEntity.getId());
//        userRoleEntity.setRole(new RoleEntity(userRole.getId()));
//        roleDAO.removeUserRole(userRoleEntity);
//        return false;  //To change body of implemented methods use File | Settings | File Templates.
//    }


    @Override
    public List<EmployeeEntity> listEmployees(Filter filter) {

        return userDAO.getEmployees(filter.getStart(), filter.getPageSize());  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EmployeeEntity getEmployee(long employeeid) throws EntityNotFoundException {
        return userDAO.getEmployee(employeeid);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setCreated(new Date().getTime());
        employeeEntity.setLastModified(new Date().getTime());
        employeeEntity.setPassword(passwordEncoder.encodePassword(employeeEntity.getPassword(), "accept"));
        return userDAO.saveEmployee(employeeEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        employeeEntity.setLastModified(new Date().getTime());
        employeeEntity.setPassword(passwordEncoder.encodePassword(employeeEntity.getPassword(), "accept"));

        return userDAO.updateEmployee(employeeEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<EmployeeEntity> listEmployee(String userName) {
        return userDAO.listEmployee(userName);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public EmployeeEntity getEmployeeByUserName(String s) throws EntityNotFoundException {
        return userDAO.getEmployeeByUserName(s);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public CustomerEntity getCustomer(long employeeid) throws EntityNotFoundException {
        return userDAO.getCustomer(employeeid);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity employeeEntity) {
        return userDAO.saveCustomer(employeeEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity employeeEntity) {
        employeeEntity.setLastModified(new Date().getTime());

        return userDAO.updateCustomer(employeeEntity);  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public CustomerEntity getCustomerByUserName(String s) throws EntityNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<CustomerEntity> searchCustomer(UserFilter filter) {

        return userDAO.searchCustomer(filter);  //To change body of implemented methods use File | Settings | File Templates.
    }


}
