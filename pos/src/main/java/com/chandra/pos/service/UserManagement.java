package com.chandra.pos.service;


import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;

import com.chandra.pos.dao.entity.UserRoleEntity;
import com.chandra.pos.model.Filter;
import com.chandra.pos.model.UserFilter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/15/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserManagement {


   // public UserRoleEntity addUserRole(EmployeeEntity userEntity, RoleEntity userRole);

   // public boolean removeUserRole(EmployeeEntity userEntity, RoleEntity userRole);


    public List<EmployeeEntity> listEmployees(Filter filter);

    public EmployeeEntity getEmployee(long employeeid) throws EntityNotFoundException;

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

    public List<EmployeeEntity> listEmployee(String userName);

    EmployeeEntity getEmployeeByUserName(String s) throws EntityNotFoundException;

    public CustomerEntity getCustomer(long employeeid) throws EntityNotFoundException;

    public CustomerEntity saveCustomer(CustomerEntity employeeEntity);

    public CustomerEntity updateCustomer(CustomerEntity employeeEntity);

    public CustomerEntity getCustomerByUserName(String s) throws EntityNotFoundException;

    public List<CustomerEntity> searchCustomer(UserFilter filter);


}
