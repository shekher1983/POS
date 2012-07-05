package com.chandra.pos.service;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CategoryEntity;
import com.chandra.pos.dao.entity.ProductEntity;
import com.chandra.pos.model.Filter;
import com.chandra.pos.model.ProductFilter;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 11:50 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductService {

    /*
        Create a  new inventory item
     */
    boolean createProduct(ProductEntity product);

    /*

   Delete a inventory item
    */
    boolean removeProduct(long id);

    /*

    */
    ProductEntity getProduct(long id) throws EntityNotFoundException;


    List<ProductEntity> listProducts(Filter filter);

    List<ProductEntity> searchProducts(ProductFilter filter);

    ProductEntity updateProduct(ProductEntity product);

    public CategoryEntity getCategory(long categoryId) throws EntityNotFoundException;

    public List<CategoryEntity> listCategory(Filter filter);
}
