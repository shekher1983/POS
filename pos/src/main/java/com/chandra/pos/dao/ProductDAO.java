package com.chandra.pos.dao;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.ProductEntity;
import com.chandra.pos.model.ProductFilter;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/14/12
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDAO {


    public ProductEntity getProduct(long id) throws EntityNotFoundException;

    public ProductEntity saveProduct(ProductEntity product);

    public ProductEntity updateProduct(ProductEntity product);


    public List<ProductEntity> searchProducts(ProductFilter query);


    boolean removeProduct(long id);

    List<ProductEntity> getProducts(int start, int pageSize);
}
