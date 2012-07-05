package com.chandra.pos.web.employee.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.EmployeeEntity;
import com.chandra.pos.dao.entity.UserRoleEntity;
import com.chandra.pos.model.Filter;
import com.chandra.pos.model.Role;
import com.chandra.pos.service.UserManagement;
import com.chandra.pos.web.CRUDAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/9/12
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeAction extends ActionSupport implements CRUDAction {


    private UserManagement userManagement;


    private List<EmployeeEntity> employeeEntities;

    private List<Integer> roles;
    private String password;



    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    private EmployeeEntity userEntity;


    public EmployeeEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(EmployeeEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String doHome() {
        Filter filter = new Filter(0, 10);
        this.employeeEntities = userManagement.listEmployees(filter);

        return SUCCESS;


    }

    @SkipValidation
    public String doNew() {

        return INPUT;
    }

    @Override
    public String doDelete() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doSave() {

        try {
            userManagement.getEmployeeByUserName(this.getUserName());
            this.addFieldError("userName", "User Name already assigned");
            return INPUT;
        } catch (EntityNotFoundException e) {

        }

        this.userEntity = this.loadUser();

        this.userEntity.setUserName(this.userName);
        this.userEntity.setPassword(this.password);
        Set<UserRoleEntity> roleEntities = new HashSet<UserRoleEntity>();

        if (roles != null)
            for (Integer roleId : roles) {

                UserRoleEntity role = new UserRoleEntity();
                role.setRole( Role.getType(roleId));
                role.setCreated(new Date().getTime());
                role.setUser(userEntity);
                // userManagement.addUserRole(userEntity, role);
                roleEntities.add(role);

            }
        userEntity.setRoles(roleEntities);

        EmployeeEntity userEntity = userManagement.saveEmployee(this.userEntity);

        return SUCCESS;
    }

    @Override
    public String doSearch() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @SkipValidation
    public String doEdit() {
        try {
            this.userEntity = userManagement.getEmployee(id);
            this.setFirstName(userEntity.getFirstName());
            this.setLastName(userEntity.getLastName());
            this.setCity(userEntity.getCity());
            this.setAddress(userEntity.getAddress());
            this.setEmail(userEntity.getEmail());
            this.setZipCode(userEntity.getZipCode());
            this.setNote(userEntity.getNote());
            this.setPrimaryCell(userEntity.getPrimaryCell());
            this.setId(userEntity.getId());
            this.setState(userEntity.getState());
            this.setUserName(userEntity.getUserName());
            Set<UserRoleEntity> roleEntitySet=userEntity.getRoles();
            Iterator it=roleEntitySet.iterator();

            while (it.hasNext()){
               if(roles ==null)
                   roles=new ArrayList<Integer>();

                UserRoleEntity temp=  (UserRoleEntity)it.next();


                roles.add(temp.getRole().getId());


            }


        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        //userManagement.getUserRoles(id);
        return INPUT;
    }

    public String doUpdate() {

        EmployeeEntity temp = null;
        try {
            temp = userManagement.getEmployee(getId());
            temp.getRoles().clear();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        EmployeeEntity userEntity = loadUser();
        userEntity.setId(getId());
        userEntity.setCreated(temp.getCreated());
        // userEntity.setType(temp.getType());
        userEntity.setUserName(temp.getUserName());
        Set<UserRoleEntity> roleEntities = new HashSet<UserRoleEntity>();

        if (roles != null)
            for (Integer roleId : roles) {

                UserRoleEntity role = new UserRoleEntity();
                role.setRole( Role.getType(roleId));
                role.setCreated(new Date().getTime());
                role.setUser(userEntity);
                // userManagement.addUserRole(userEntity, role);
                roleEntities.add(role);

            }
        userEntity.setRoles(roleEntities);
        userManagement.updateEmployee(userEntity);
//        listUserRoles = userManagement.getUserRoles(getId());
//
//        List<Long> ignoreRoles = new ArrayList<Long>();           //hold list of assigned roles that need to be kept aside
//        for (UserRole roleId : listUserRoles) {        //scan current assigned roles
//
//            if (!roles.contains(roleId.getRole().getId())) {             //check new roles list contain assigned roles if not then remove  role.
//                userManagement.removeUserRole(userEntity, roleId.getRole());
//
//
//            } else
//
//                ignoreRoles.add(roleId.getRole().getId());   //dont touch these roles    already der in database
//
//        }

//        for (Long roleId : roles) {
//            Role role = new Role();
//            role.setId(roleId);
//            if (!ignoreRoles.contains(role))                  //check while updating roles already exist
//                userManagement.addUserRole(userEntity, role);        //add new roles
//
//        }
        return SUCCESS;
    }


    protected EmployeeEntity loadUser() {
        EmployeeEntity userEntity = new EmployeeEntity();
        userEntity.setFirstName(this.firstName);
        userEntity.setLastName(this.lastName);
        userEntity.setEmail(this.email);
        //userEntity.setUserName(this.userName);
        userEntity.setCity(this.city);
        // userEntity.setNickName(this.middleName);
        userEntity.setZipCode(zipCode);
        userEntity.setAddress(this.address);
        userEntity.setState(this.state);
        // userEntity.setCountry(this.country);
        userEntity.setPrimaryCell(this.primaryCell);
        userEntity.setNote(this.note);
        userEntity.setPassword(password);


        return userEntity;
    }

    @SkipValidation
    public String doList() {
        Filter filter = new Filter(0, 10);
        this.employeeEntities = userManagement.listEmployees(filter);

        return SUCCESS;
    }

    public String execute() throws Exception {

        return SUCCESS;
    }

    private long id;
    private String firstName;

    private String lastName;

    private String userName;

    private String middleName;

    private String email;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String primaryCell;
    private String secondaryCell;
    private String note;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @RequiredStringValidator(message = "You must enter a Name.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }


    @RequiredStringValidator(message = "You must enter a UserName.")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimaryCell() {
        return primaryCell;
    }

    public void setPrimaryCell(String primaryCell) {
        this.primaryCell = primaryCell;
    }

    public String getSecondaryCell() {
        return secondaryCell;
    }

    public void setSecondaryCell(String secondaryCell) {
        this.secondaryCell = secondaryCell;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Role[] getAllRoles() {
        return Role.values();
    }



    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
