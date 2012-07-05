package com.chandra.pos.service.impl;


import com.chandra.pos.service.IndexManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * UserEntity: chkumar
 * Date: 5/28/12
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
@Transactional
public class IndexManagerImpl implements IndexManager {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//
//    public IndexManagerImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//
//    }

    @PostConstruct
    public void buildIndex() {

//    System.out.println("*******************Indexing************************");
//     FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
//        try {
//           fullTextSession.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }

    }

}
