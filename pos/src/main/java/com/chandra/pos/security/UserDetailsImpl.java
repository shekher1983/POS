package com.chandra.pos.security;

import com.chandra.pos.dao.entity.EmployeeEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/31/12
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailsImpl implements UserDetails {


    private EmployeeEntity user;
    private Collection<GrantedAuthority> authorities;

    private String salt;

    public UserDetailsImpl(EmployeeEntity userEntity, Collection<GrantedAuthority> authorities) {
        this.user = userEntity;
        this.authorities = authorities;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getPassword() {
        return user.getPassword();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEnabled() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public EmployeeEntity getUser() {
        return user;
    }


}
