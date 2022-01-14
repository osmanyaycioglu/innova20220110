package com.training.spring.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.customer.data.CustomerQuery;
import com.training.spring.customer.model.Customer;

@Service
public class CustomerQueryService {

    @Autowired
    private CustomerQuery customerQuery;

    public List<Customer> getCustomerByName(final String name) {
        return this.customerQuery.getCustomerByName(name);
    }

}
