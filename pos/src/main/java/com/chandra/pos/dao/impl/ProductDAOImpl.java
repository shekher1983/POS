package com.chandra.pos.dao.impl;

import com.chandra.pos.EntityNotFoundException;
import com.chandra.pos.dao.ProductDAO;
import com.chandra.pos.dao.entity.ProductEntity;
import com.chandra.pos.model.ProductFilter;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/14/12
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ProductEntity getProduct(long id) throws EntityNotFoundException {

        // UserEntity entity = this.getHibernateTemplate().load(UserEntity.class, userid);
        ProductEntity entity = (ProductEntity) sessionFactory.getCurrentSession().get(ProductEntity.class, id);
        if (entity == null)
            throw new EntityNotFoundException("Object with Id -" + id + "Not Found");
        return entity;

    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {

        Long id = (Long) sessionFactory.getCurrentSession().save(product);

        product.setId(id);
        return product;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        // sessionFactory.getCurrentSession().beginTransaction().begin();
        sessionFactory.getCurrentSession().update(product);
        //  sessionFactory.getCurrentSession().beginTransaction().commit();

        return product;

    }


    @Override
    public List<ProductEntity> searchProducts(ProductFilter filter) {


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductEntity.class);

        if (filter.getNameQuery() != null && !filter.getNameQuery().isEmpty())

            criteria.add(Restrictions.like("name", "%" + filter.getNameQuery() + "%"));

        if (filter.getCategory() != null)

            criteria.add(Restrictions.eq("category", filter.getCategory()));


        return criteria.list();  //To change body of implemented methods use File | Settings | File Templates.

//        FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
//       try {
//           fullTextSession
//                 .createIndexer(UserEntity.class)
//                 .batchSizeToLoadObjects(25)
//                 .cacheMode(CacheMode.NORMAL)
//                 .threadsToLoadObjects(5)
//                 .idFetchSize(150)
//                 .threadsForSubsequentFetching(20).startAndWait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//        QueryBuilder qb = fullTextSession.getSearchFactory()
//                .buildQueryBuilder().forEntity(UserEntity.class).get();
//        org.apache.lucene.search.Query query = qb.keyword().onFields("name", "description").matching(term).createQuery();
//
//        org.hibernate.Query hibQuery =
//                fullTextSession.createFullTextQuery(query, UserEntity.class);
//
//        List result = hibQuery.list();


//
//     Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductEntity.class);
//
//        DetachedCriteria subquery = DetachedCriteria.forClass(ProductEntity.class);
//        subquery.add(Restrictions.ilike("name", term));
//          subquery.
//         sessionFactory.getCurrentSession().cr

        //   return result;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean removeProduct(long id) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ProductEntity> getProducts(int start, int pageSize) {
        Query query = sessionFactory.getCurrentSession().createQuery("from ProductEntity");
        query.setFirstResult(start);
        query.setMaxResults(pageSize);
        //List obj = .createQuery(UserEntity.class);
        return query.list();
    }
}
