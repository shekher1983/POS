package com.chandra.pos.dao.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 6/1/12
 * Time: 12:03 PM
 */

@Entity
@Table(name = "EMPLOYEES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USER_NAME")})
public class EmployeeEntity {


    private String userName;
    private String password;

    private Set<UserRoleEntity> roles = new HashSet<UserRoleEntity>(0);

    public EmployeeEntity() {

        super();
    }


    @Column(name = "USER_NAME", unique = true, updatable = true, insertable = true, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD", unique = false, updatable = true, insertable = true, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.employee", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
    }

    protected long id;
    protected String firstName;
    protected String lastName;
    protected String city;

    protected long created;
    protected long lastModified;
    protected String email;


    protected String state;
    protected String zipCode;

    protected String address;


    protected String note;

    private String primaryCell;


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

    public String getPrimaryCell() {
        return primaryCell;
    }

    public void setPrimaryCell(String primaryCell) {
        this.primaryCell = primaryCell;
    }

    @Transient
    public String getName() {
        StringBuffer name = new StringBuffer();
        if (this.firstName != null)
            name.append(firstName + " ");
        if (this.lastName != null)
            name.append(lastName);
        if (name.toString().trim().isEmpty())
            return this.userName;
        else
            return name.toString();
    }
}
