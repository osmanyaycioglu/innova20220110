package com.training.spring.customer.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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

    public String restCall(final Customer customerParam) {
        RestTemplate restTemplateLoc = new RestTemplate();
        String str = restTemplateLoc.postForObject("http://127.0.0.1:8090/cs/add",
                                                   customerParam,
                                                   String.class);
        this.cd.insert(customerParam);
        return "OK";
    }


}
