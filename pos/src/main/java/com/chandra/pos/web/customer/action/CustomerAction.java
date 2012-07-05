package com.chandra.pos.web.customer.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.model.UserFilter;
import com.chandra.pos.service.UserManagement;
import com.chandra.pos.web.CRUDAction;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/22/12
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerAction extends ActionSupport implements CRUDAction {


    private UserManagement userManagement;


    private String companyName;
    private String term;

    private List<CustomerEntity> userEntities;

    public List<CustomerEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<CustomerEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public UserManagement getUserManagement() {
        return userManagement;
    }

    public void setUserManagement(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    private CustomerEntity userEntity;


    public CustomerEntity getUserEntity() {
        return userEntity;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String doHome() {

        UserFilter filter = new UserFilter(0, 10);

        if (term != null && !term.isEmpty())
            filter.setNameQuery(term.trim());
        if (getCity() != null && !getCity().isEmpty())
            filter.setCity(getCity());

        this.userEntities = getUserManagement().searchCustomer(filter);

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @SkipValidation
    public String doNew() {
        return INPUT;
    }

    @Override
    public String doDelete() {

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doList() {

        UserFilter filter = new UserFilter(0, 10);

        if (term != null && !term.isEmpty())
            filter.setNameQuery(term);
        if (getCity() != null && !getCity().isEmpty())
            filter.setCity(getCity());

        this.userEntities = getUserManagement().searchCustomer(filter);

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doSave() {


        CustomerEntity userEntity = userManagement.saveCustomer(loadUser());

        return SUCCESS;
    }

    @Override
    public String doSearch() {
        UserFilter filter = new UserFilter(0, 10);

              if (term != null && !term.isEmpty())
                  filter.setNameQuery(term.trim());
              if (getCity() != null && !getCity().isEmpty())
                  filter.setCity(getCity());
                 filter.setSupplier(false);
              this.userEntities = getUserManagement().searchCustomer(filter);

              return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
         //To change body of implemented methods use File | Settings | File Templates.
    }

    @SkipValidation
    public String doEdit() {
        try {
            this.userEntity = userManagement.getCustomer(id);
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
            this.setNickName(userEntity.getNickName());
            this.setCompanyName(userEntity.getCompanyName());
            this.setSupplier(userEntity.isSupplier());

        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return INPUT;
    }

    public String doUpdate() {

        CustomerEntity temp = null;
        try {
            temp = userManagement.getCustomer(getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }
        CustomerEntity userEntity = loadUser();
        userEntity.setId(getId());
        userEntity.setCreated(temp.getCreated());
        userManagement.updateCustomer(userEntity);
        return SUCCESS;
    }


    protected CustomerEntity loadUser() {
        CustomerEntity userEntity = new CustomerEntity();
        userEntity.setFirstName(this.firstName);
        userEntity.setLastName(this.lastName);
        userEntity.setEmail(this.email);
        // userEntity.setUserName(this.userName);
        userEntity.setCity(this.city);
        userEntity.setZipCode(zipCode);
        userEntity.setAddress(this.address);
        userEntity.setState(this.state);
        userEntity.setPrimaryCell(this.primaryCell);
        userEntity.setNote(this.note);
        userEntity.setNickName(this.nickName);
        userEntity.setSupplier(this.supplier);
        userEntity.setCompanyName(this.companyName);


        return userEntity;
    }

    //    @SkipValidation
//    public String doList(){
//        Filter filter=new Filter();
//     List<UserEntity> userList=userManagement.searchUser(filter);
//     return SUCCESS;
//    }
    public String doSuggest() {
        UserFilter filter = new UserFilter();
        if (term != null)
            filter.setNameQuery(term);
        List<CustomerEntity> userEntityList = getUserManagement().searchCustomer(filter);
        this.userEntities = userEntityList;


        return SUCCESS;
    }

    public String execute() throws Exception {

        return SUCCESS;
    }

    private long id;
    private String firstName;

    private String lastName;

    private String userName;

    private String nickName;

    private String email;
    private String address;
    private String zipCode;
    private String city;
    private String state;
    private String country;
    private String primaryCell;
    private String secondaryCell;
    private String note;

    private boolean supplier;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @RequiredStringValidator(message = "You must enter a Name.")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
