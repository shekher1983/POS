package com.chandra.pos.web.item.action;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.entity.CategoryEntity;
import com.chandra.pos.dao.entity.ProductEntity;
import com.chandra.pos.model.Filter;
import com.chandra.pos.model.ProductFilter;
import com.chandra.pos.service.ProductService;
import com.chandra.pos.web.CRUDAction;
import com.opensymphony.xwork2.ActionSupport;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/22/12
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class ItemAction extends ActionSupport implements CRUDAction {


    private List<ProductEntity> products;
    private ProductEntity product;

    private String Name;

    private String description;

    private long id;
    private long category;

    private String term;
    private BigDecimal salePrice;


    private ProductService productService;
    private List<CategoryEntity> listCategory;

    public com.chandra.pos.service.ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String doHome() {
        ProductFilter filter = new ProductFilter();
        try {
            CategoryEntity categoryEntity = null;
            if (getCategory() > 0)
                categoryEntity = productService.getCategory(getCategory());
            filter.setCategory(categoryEntity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        filter.setPageSize(10);
        filter.setStart(0);

        products = productService.searchProducts(filter);

        return SUCCESS;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doNew() {

        Filter filter = new Filter(0, 10);
        listCategory = productService.listCategory(filter);
        return INPUT;
    }

    @Override
    public String doDelete() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String doSave() {
        this.product = new ProductEntity();

        loadProductData(product);
        productService.createProduct(product);

        return SUCCESS;
    }

    public String doEdit() {
        try {
            product = productService.getProduct(getId());
            this.setName(product.getName());
            this.setDescription(product.getDescription());
            this.setSalePrice(product.getSalePrice());
            this.setCategory(product.getCategory().getId());
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        Filter filter = new Filter(0, 10);

        listCategory = productService.listCategory(filter);

        return INPUT;
    }

    public String doUpdate() {

        try {
            this.product = productService.getProduct(getId());
        } catch (EntityNotFoundException e) {
            return INPUT;
        }

        this.product = loadProductData(product);
        productService.updateProduct(product);
        return SUCCESS;
    }

    public String doList() {
        ProductFilter filter = new ProductFilter();
        try {
            CategoryEntity categoryEntity = null;
            if (getCategory() > 0)
                categoryEntity = productService.getCategory(getCategory());
            filter.setCategory(categoryEntity);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        filter.setPageSize(10);
        filter.setStart(0);

        products = productService.searchProducts(filter);
        return SUCCESS;
    }

    public String doSearch() {
        ProductFilter filter = new ProductFilter(0, 10);
        filter.setNameQuery(term);
        products = productService.searchProducts(filter);
        return SUCCESS;
    }

    public String doSuggest() {
        ProductFilter filter = new ProductFilter(0, 10);
        filter.setNameQuery(term);
        products = productService.searchProducts(filter);
        return SUCCESS;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public List<CategoryEntity> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<CategoryEntity> listCategory) {
        this.listCategory = listCategory;
    }

    private ProductEntity loadProductData(ProductEntity product) {

        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setCategory(new CategoryEntity(this.getCategory()));
        product.setSalePrice(salePrice);

        return product;

    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
