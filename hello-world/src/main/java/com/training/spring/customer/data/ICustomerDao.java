package com.training.spring.customer.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.spring.customer.model.Customer;

public interface ICustomerDao extends CrudRepository<Customer, Long> {

    List<Customer> findByName(String name);

    List<Customer> findByNameAndSurname(String name,
                                        String surname);

    List<Customer> findByNameAndSurnameOrderByName(String name,
                                                   String surname);

    List<Customer> findByNameIn(List<String> name);


    @Query("select c from Customer c where c.name=:isim")
    List<Customer> searchName(@Param("isim") String name);

    @Query("select c from Customer c where c.name=?1")
    List<Customer> searchName2(String name);

    @Query(value = "select * from customer c where c.name=:isim", nativeQuery = true)
    List<Customer> searchNameNative(@Param("isim") String name);

}
