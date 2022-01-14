package com.training.spring.rest.mappings;

import com.training.spring.customer.model.Customer;
import com.training.spring.rest.model.CustomerRest;

public class CustomerMappings {

    public static Customer toCustomer(final CustomerRest customerParam) {
        Customer customerLoc = new Customer();
        customerLoc.setName(customerParam.getName());
        customerLoc.setSurname(customerParam.getSurname());
        customerLoc.setHeight(customerParam.getHeight());
        return customerLoc;
    }

}
