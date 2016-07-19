package com.vatit.standard.controller;

import com.vatit.standard.entities.Customer;
import com.vatit.standard.service.CustomerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody @Valid Customer customer) {
        return customerService.createCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public Customer getCustomerById(@PathVariable long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterBy")
    public Customer getCustomerByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return customerService.findByFirstNameAndLastName(firstName, lastName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterByStoreId")
    public List<Customer> getCustomersByStoreId(@RequestParam int value) {
        return customerService.getCustomersByStoreId(value);
    }


}
