package com.chandra.pos.dao.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/14/12
 * Time: 12:58 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CUSTOMERS")
public class CustomerEntity {


    protected long id;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String nickName;

    protected long created;
    protected long lastModified;
    protected String email;


    protected String state;
    protected String zipCode;

    protected String address;


    protected String note;

    private String primaryCell;
    private String companyName;

    private boolean supplier;

    @Column(name = "IS_SUPPLIER", nullable = false, columnDefinition = "tinyint default false")
    public boolean isSupplier() {
        return supplier;
    }

    public void setSupplier(boolean supplier) {
        this.supplier = supplier;
    }

    public CustomerEntity(int id) {
        this.id = id;
    }

    public CustomerEntity() {
    }


    @Column(name = "NICK_NAME", unique = false, updatable = true, insertable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    @Column(name = "ADDRESS", unique = false, updatable = true, insertable = true, length = 512)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, updatable = false, insertable = false)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "FIRST_NAME", unique = false, updatable = true, insertable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "LAST_NAME", unique = false, updatable = true, insertable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name = "CITY", unique = false, updatable = true, insertable = true, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    @Column(name = "LAST_MODIFIED")
    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    @Column(name = "EMAIL", unique = true, updatable = true, insertable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "STATE", unique = false, updatable = true, insertable = true, length = 100)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Column(name = "ZIP_CODE", unique = false, updatable = true, insertable = true, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Column(name = "NOTE", unique = false, updatable = true, insertable = true, length = 512)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Column(name = "PHONE_NUMBER", unique = false, updatable = true, insertable = true, length = 10)
    public String getPrimaryCell() {
        return primaryCell;
    }

    public void setPrimaryCell(String primaryCell) {
        this.primaryCell = primaryCell;
    }

    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Transient
    public String getName() {
        StringBuffer name = new StringBuffer();
        if (this.firstName != null)
            name.append(firstName + " ");
        if (this.lastName != null)
            name.append(lastName);
        return name.toString();
    }
}