package com.vatit.standard.controllers;

import com.vatit.standard.entities.Customer;
import com.vatit.standard.entities.FinancialStatus;
import com.vatit.standard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/status")
    public List<Customer> getCustomers(@RequestParam String lastName,
                                       @RequestParam List<FinancialStatus> statuses) {
        return customerRepository.findByLastNameAndStatusIn(lastName, statuses);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/by")
    public List<Customer> getCustomer(@RequestParam String firstName, @RequestParam String lastName) {
        return customerRepository.findByFirstNameAndLastNameOrderByEnrollmentDesc(firstName, lastName);
    }
}
