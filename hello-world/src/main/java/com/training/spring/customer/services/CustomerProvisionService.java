package com.training.spring.customer.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.customer.data.CustomerDao;
import com.training.spring.customer.model.Customer;

@Service
public class CustomerProvisionService {

    @Autowired
    private CustomerDao cd;

    @Transactional(propagation = Propagation.REQUIRED)
    public String add(final Customer customerParam) {
        this.cd.insert(customerParam);
        return "OK";
    }

}
