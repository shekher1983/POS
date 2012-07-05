package com.chandra.pos.model;

import com.chandra.pos.dao.entity.CategoryEntity;

/**
 * Created by IntelliJ IDEA.
 * User: chkumar
 * Date: 6/28/12
 * Time: 4:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductFilter extends Filter {

    private CategoryEntity category;

    public ProductFilter(int start, int pageSize) {
        super(start, pageSize);
    }

    public ProductFilter() {

    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
