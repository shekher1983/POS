package com.chandra.pos.dao;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.dao.entity.EmployeeEntity;
import com.chandra.pos.model.UserFilter;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/15/12
 * Time: 5:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {


    public EmployeeEntity getEmployee(long employeeid) throws EntityNotFoundException;

    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

    public List<EmployeeEntity> listEmployee(String userName);

    public List<EmployeeEntity> getEmployees(int start, int resultSize);

    EmployeeEntity getEmployeeByUserName(String s) throws EntityNotFoundException;

    List<CustomerEntity> listCustomers(UserFilter filter);

    public CustomerEntity getCustomer(long employeeid) throws EntityNotFoundException;

    public CustomerEntity saveCustomer(CustomerEntity employeeEntity);

    public CustomerEntity updateCustomer(CustomerEntity employeeEntity);

    public List<CustomerEntity> listCustomer(String userName);

    CustomerEntity getCustomerByUserName(String s) throws EntityNotFoundException;


    List<CustomerEntity> searchCustomerByName(UserFilter filter);

    List<CustomerEntity> searchCustomer(UserFilter filter);
}
