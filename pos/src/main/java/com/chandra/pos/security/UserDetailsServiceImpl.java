package com.chandra.pos.security;


import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.EmployeeEntity;
import com.chandra.pos.dao.entity.UserRoleEntity;
import com.chandra.pos.service.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/31/12
 * Time: 1:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("userDetailsService")
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserManagement userManagement;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        EmployeeEntity userEntity = null;
        try {
            userEntity = userManagement.getEmployeeByUserName(username);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("Could not find: " + username);

        }

        String password = userEntity.getPassword();

        //List<UserRoleEntity> roleEntityList = roleDAO.getUserRoles(userEntity.getId());

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UserRoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole().name()));
        }

        UserDetails user = new UserDetailsImpl(userEntity, authorities);


        return user;
    }
}
