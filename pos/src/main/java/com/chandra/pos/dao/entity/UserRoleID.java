package com.chandra.pos.dao.entity;

import com.chandra.pos.model.Role;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 6/9/12
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class UserRoleID implements Serializable {

    private EmployeeEntity employee;
    private Role role;

    @ManyToOne
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity user) {
        this.employee = user;
    }


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ROLE_ID")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemId that = (OrderItemId) o;

        // if (user != null ? !user.equals(that.user) : that.user != null) return false;
        // if (role != null ? !role.equals(that.role) : that.role != null)
        //      return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (role != null ? role.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
