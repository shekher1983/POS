package com.chandra.pos.dao;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CategoryEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/29/12
 * Time: 11:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDAO {

    public CategoryEntity getCategory(long categoryid) throws EntityNotFoundException;

    public CategoryEntity saveCategory(CategoryEntity categoryEntity);

    public CategoryEntity updateCategory(CategoryEntity categoryEntity);

    public List<CategoryEntity> searchCategory(String name);

    public List<CategoryEntity> listCategory(int start, int pageSize);


}
