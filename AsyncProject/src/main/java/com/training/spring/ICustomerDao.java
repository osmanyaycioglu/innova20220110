package com.training.spring;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.repository.CrudRepository;

import reactor.core.publisher.Flux;

public interface ICustomerDao extends CrudRepository<Customer, Long> {


    Flux<Customer> findByName(String name);

    Future<List<Customer>> findByNameAndSurname(String name);

}
