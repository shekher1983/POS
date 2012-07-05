package com.chandra.pos.dao.entity;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/23/12
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SUPPLIERS")
public class SupplierEntity {


    protected long id;
    protected String firstName;
    protected String lastName;
    protected String city;
    protected String companyName;

    protected long created;
    protected long lastModified;
    protected String email;


    protected String state;
    protected String zipCode;

    protected String address;


    protected String note;

    private String phoneNumber;


    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "CITY")
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "ZIP_CODE")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
