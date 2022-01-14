package com.training.spring.customer.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.customer.model.Customer;

@Service
public class CustomerQuery {

    @Autowired
    private ICustomerDao cd;

    public List<Customer> getCustomerByName(final String name) {
        return this.cd.findByName(name);
    }

}
