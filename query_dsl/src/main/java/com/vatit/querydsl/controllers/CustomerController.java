package com.vatit.querydsl.controllers;

import com.querydsl.core.types.Predicate;
import com.vatit.querydsl.entities.Customer;
import com.vatit.querydsl.entities.Status;
import com.vatit.querydsl.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.vatit.querydsl.repository.predicates.CustomerPredicates.active;
import static com.vatit.querydsl.repository.predicates.CustomerPredicates.belongToStore;
import static com.vatit.querydsl.repository.predicates.CustomerPredicates.orderByCreateDate;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    public List<Customer> getCustomersByStoreId(@RequestParam int id) {
        return (List<Customer>) customerRepository.findAll(belongToStore(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public List<Customer> getCustomersByStatus(@RequestParam Status status) {
        return (List<Customer>) customerRepository.findAll(active(status), orderByCreateDate());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/predicate")
    public Customer getCustomer(@QuerydslPredicate(root = Customer.class) Predicate predicate) {
        return customerRepository.findOne(predicate);
    }


}
