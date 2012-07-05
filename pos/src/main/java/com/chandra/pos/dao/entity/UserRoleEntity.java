package com.chandra.pos.dao.entity;


import com.chandra.pos.model.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 6/1/12
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name = "USER_ROLES")
@AssociationOverrides({
        @AssociationOverride(name = "pk.roles",
                joinColumns = @JoinColumn(name = "ROLE_ID")),
        @AssociationOverride(name = "pk.employee",
                joinColumns = @JoinColumn(name = "USER_ID"))})
public class UserRoleEntity implements Serializable {


    private long created;

    private UserRoleID pk = new UserRoleID();

    @Transient
    public EmployeeEntity getUser() {
        return pk.getEmployee();
    }

    public void setUser(EmployeeEntity user) {
        pk.setEmployee(user);
    }

    @EmbeddedId
    public UserRoleID getPk() {
        return pk;
    }

    public void setPk(UserRoleID pk) {
        this.pk = pk;
    }


    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }


    @Transient
    public Role getRole() {
        return pk.getRole();
    }

    public void setRole(Role role) {
        pk.setRole(role);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        UserRoleEntity that = (UserRoleEntity) o;

        if (getPk() != null ? !getPk().equals(that.getPk())
                : that.getPk() != null)
            return false;

        return true;
    }

    public int hashCode() {
        return (getPk() != null ? getPk().hashCode() : 0);
    }

}
