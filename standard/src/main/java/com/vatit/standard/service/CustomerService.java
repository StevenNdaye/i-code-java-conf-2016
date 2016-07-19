package com.vatit.standard.service;

import com.vatit.standard.entities.Customer;
import com.vatit.standard.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }


    public Customer getCustomerById(long customerId) {
        return customerRepository.findOne(customerId);
    }

    public Customer findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Customer> getCustomersByStoreId(int value) {
        return customerRepository.findTop15ByStoreIdOrderByCustomerIdDesc(value);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
