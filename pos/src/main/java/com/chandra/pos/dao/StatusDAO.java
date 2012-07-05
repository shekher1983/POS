package com.chandra.pos.dao;

import com.chandra.pos.dao.entity.StatusEntity;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/18/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StatusDAO {

    public StatusEntity getStatus(long id);

    public List<StatusEntity> getAllStatus();


}
