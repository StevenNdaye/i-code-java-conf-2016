package com.vatit.standard.repository;

import com.vatit.standard.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findTop15ByStoreIdOrderByCustomerIdDesc(int value);
}
