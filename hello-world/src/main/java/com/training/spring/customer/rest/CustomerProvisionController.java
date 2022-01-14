package com.training.spring.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.customer.services.CustomerProvisionService;
import com.training.spring.rest.mappings.CustomerMappings;
import com.training.spring.rest.model.CustomerRest;

@RestController
@RequestMapping("/api/v1/custom/provision")
public class CustomerProvisionController {

    @Autowired
    private CustomerProvisionService cps;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final CustomerRest customer) {
        if (customer.getName()
                    .equals("xyz")) {
            throw new IllegalArgumentException("xyz olamaz");
        }
        this.cps.add(CustomerMappings.toCustomer(customer));
        return "OK";
    }

    // Yapma
    @PostMapping("/dont/{opertion}")
    public ResponseEntity<?> doEverything(@PathVariable("opertion") final String op,
                                          @RequestBody final CustomerRest customer) {
        switch (op) {
            case "add":
                return ResponseEntity.status(HttpStatus.OK)
                                     .body("OK");

            default:
                break;
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body("Wrong operation");
    }

}
