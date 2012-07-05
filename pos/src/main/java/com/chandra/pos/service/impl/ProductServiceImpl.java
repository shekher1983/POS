package com.chandra.pos.service.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.CategoryDAO;
import com.chandra.pos.dao.ProductDAO;
import com.chandra.pos.dao.entity.CategoryEntity;
import com.chandra.pos.dao.entity.ProductEntity;
import com.chandra.pos.model.Filter;
import com.chandra.pos.model.ProductFilter;
import com.chandra.pos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/11/12
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Service("productService")
@Transactional(readOnly = false)
public class ProductServiceImpl implements ProductService {


    private ProductDAO productDAO;

    private CategoryDAO categoryDAO;


    public ProductDAO getProductDAO() {
        return productDAO;
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    @Autowired
    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean createProduct(ProductEntity product) {

        // ProductEntity entity = ObjectMapperUtil.mapModelToEntity(product);

        product.setLastUpdated(new Date().getTime());

        productDAO.saveProduct(product);

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @Transactional(readOnly = false)
    public boolean removeProduct(long id) {
        return productDAO.removeProduct(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public CategoryEntity getCategory(long categoryId) throws EntityNotFoundException {

        return categoryDAO.getCategory(categoryId);
    }

    public List<CategoryEntity> listCategory(Filter filter) {

        List<CategoryEntity> categoryEntityList;
        categoryEntityList = categoryDAO.listCategory(filter.getStart(), filter.getPageSize());  //To change body of implemented methods use File | Settings | File Templates.


        return categoryEntityList;
    }

    @Override
    public ProductEntity getProduct(long productId) throws EntityNotFoundException {
        ProductEntity entity = null;
        entity = productDAO.getProduct(productId);

        return entity;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ProductEntity> listProducts(Filter filter) {
        List<ProductEntity> productEntityList;
        productEntityList = productDAO.getProducts(filter.getStart(), filter.getPageSize());  //To change body of implemented methods use File | Settings | File Templates.


        return productEntityList;
    }

    @Override
    public List<ProductEntity> searchProducts(ProductFilter filter) {

        List<ProductEntity> productEntityList;

        productEntityList = productDAO.searchProducts(filter);  //To change body of implemented methods use File | Settings | File Templates.


        return productEntityList;

    }

    @Override
    @Transactional(readOnly = false)
    public ProductEntity updateProduct(ProductEntity product) {
        // ProductEntity entity = ObjectMapperUtil.mapModelToEntity(product);
        product.setLastUpdated(new Date().getTime());
        productDAO.updateProduct(product);

        return product;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
