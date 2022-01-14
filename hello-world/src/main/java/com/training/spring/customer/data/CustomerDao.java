package com.training.spring.customer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.customer.model.Customer;

@Service
public class CustomerDao {

    @Autowired
    private ICustomerDao cDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void insert(final Customer customerParam) {
        this.cDao.save(customerParam);
    }

}
