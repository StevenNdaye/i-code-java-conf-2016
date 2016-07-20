package com.vatit.standard.repository;

import com.vatit.standard.entities.Customer;
import com.vatit.standard.entities.FinancialStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface Repository extends CrudRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    class Specs {
        public static Specification<Customer> firstNameIs(String firstName) {
            return (root, query, cb) -> cb.like(root.get("firstName"), firstName);
        }

        public static Specification<Customer> lastNameIs(String lastName) {
            return (root, query, cb) -> cb.like(root.get("lastName"), lastName);
        }

        public static Specification<Customer> statusIn(List<FinancialStatus> statuses) {
            return (root, query, cb) -> cb.isTrue(root.get("status").in(statuses));
        }

        public static Specification<Customer> birthDateIsBetween(Date from, Date to) {
            return (root, query, cb) -> cb.between(root.get("birthDate"), from, to);
        }

        public static Specification<Customer> birthDateIsBefore(Date limit) {
            return (root, query, cb) -> cb.lessThan(root.get("birthDate"), limit);
        }

        public static Sort orderByEnrollmentDesc() {
            return new Sort(Sort.Direction.DESC, "enrollment");
        }
    }
}
