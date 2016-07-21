package com.vatit.querydsl.repository;

import com.vatit.querydsl.entities.Customer;
import com.vatit.querydsl.entities.QCustomer;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>,
        QueryDslPredicateExecutor<Customer>,
        QuerydslBinderCustomizer<QCustomer> {

}
