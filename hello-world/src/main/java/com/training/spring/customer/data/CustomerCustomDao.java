package com.training.spring.customer.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.training.spring.customer.model.Customer;

@Repository
@Transactional
public class CustomerCustomDao {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public void insert(final Customer customerParam) {
        EntityManager emLoc = this.emf.createEntityManager();
        emLoc.joinTransaction();
        emLoc.persist(customerParam);
        //emLoc.close();
    }

}
