package com.chandra.pos.web.supplier.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CustomerEntity;
import com.chandra.pos.model.UserFilter;
import com.chandra.pos.web.CRUDAction;
import com.chandra.pos.web.customer.action.CustomerAction;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/22/12
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SupplierAction extends CustomerAction implements CRUDAction {


    private List<CustomerEntity> entityList;
    private String term;

    public List<CustomerEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<CustomerEntity> entityList) {
        this.entityList = entityList;
    }


    @Override
    public String doNew() {
        return INPUT;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doDelete() {
        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doList() {
        UserFilter filter = new UserFilter(1, 10);
        filter.setSupplier(true);

        entityList = getUserManagement().searchCustomer(filter);

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doSuggest() {
        UserFilter filter = new UserFilter(1, 10);
        filter.setSupplier(true);
        if (term != null)
            filter.setNameQuery(term);
        List<CustomerEntity> userEntityList = getUserManagement().searchCustomer(filter);
        this.entityList = userEntityList;


        return SUCCESS;
    }

    @Override
    public String doUpdate() {
        CustomerEntity temp = null;
        try {
            temp = getUserManagement().getCustomer(getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return ERROR;
        }
        CustomerEntity userEntity = loadUser();
        userEntity.setId(getId());
        userEntity.setCreated(temp.getCreated());
        getUserManagement().updateCustomer(userEntity);
        return SUCCESS;
    }

    @Override
    public String doEdit() {
        try {
            CustomerEntity customerEntity = getUserManagement().getCustomer(getId());
            this.setFirstName(customerEntity.getFirstName());
            // this.setLastModified(customerEntity.getLastModified());
            this.setAddress(customerEntity.getAddress());
            this.setCity(customerEntity.getCity());
            this.setCompanyName(customerEntity.getCompanyName());
            this.setZipCode(customerEntity.getZipCode());
            this.setNote(customerEntity.getNote());
            this.setEmail(customerEntity.getEmail());
            this.setPrimaryCell(customerEntity.getPrimaryCell());
            this.setState(customerEntity.getState());

        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return INPUT;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String doSave() {

        super.doSave();

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected String companyName;


    private String phoneNumber;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
