package com.innova.ee.db;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Stateless
@LocalBean
public class CustomerDao {

    @PersistenceContext(unitName = "InnovaEE")
    private EntityManager em;
    //    @Resource(lookup = "")
    //    private DataSource    dataSource;

    //Normal java
    @Transactional(value = TxType.SUPPORTS)
    public void insertJava(final Customer customerParam) {
        // this.em.joinTransaction();
        this.em.getTransaction()
               .begin();
        try {
            this.em.persist(this.em);
            this.em.getTransaction()
                   .commit();
        } catch (Exception eLoc) {
            this.em.getTransaction()
                   .rollback();
        }
        //        try {
        //            Connection connectionLoc = this.dataSource.getConnection();
        //            connectionLoc.setTransactionIsolation(0);
        //        } catch (SQLException e) {
        //            // TODO Auto-generated catch block
        //            e.printStackTrace();
        //        }
    }

    public void insert(final Customer customerParam) {
        this.em.persist(customerParam);
        //        this.em.detach(customerParam);
        //        em.clear();
        //        em.close();
        customerParam.setName("osman");
    }

    public List<Customer> getCustomerByName(final String name) {
        TypedQuery<Customer> createQueryLoc = this.em.createQuery("select c from Customer c where c.name=:isim",
                                                                  Customer.class);
        createQueryLoc.setParameter("isim",
                                    name);
        return createQueryLoc.getResultList();

    }

    @SuppressWarnings("unchecked")
    public List<Customer> getCustomerByNativeName(final String name) {
        Query createQueryLoc = this.em.createNativeQuery("select * from customer c where c.name=:isim",
                                                         Customer.class);
        createQueryLoc.setParameter("isim",
                                    name);
        return createQueryLoc.getResultList();
    }

}
